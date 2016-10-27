package com.oblenergo.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.oblenergo.DTO.TimeDTO;
import com.oblenergo.editor.CarEditor;
import com.oblenergo.editor.ServiceEditor;
import com.oblenergo.model.Car;
import com.oblenergo.model.Orders;
import com.oblenergo.model.WorkType;
import com.oblenergo.service.CarService;
import com.oblenergo.service.ItextService;
import com.oblenergo.service.OrderServise;
import com.oblenergo.service.SapService;
import com.oblenergo.service.WorkTypeService;
import com.oblenergo.validator.ClientValidator;

@Controller
@RequestMapping(value = "/")
public class UserOrderController {
  Logger LOGGER = Logger.getLogger(UserOrderController.class);

  private static final String ITEMSWORKTYPE = "typeWorks";
  private static final String ITEMSCAR = "cars";
  private static final String ORDER = "orders";
  private static final String DATAFORMAT = "YYYY-MM-DD HH:mm:ss";

  @Autowired
  private WorkTypeService workTypeServiceImpl;

  @Autowired
  private OrderServise orderServiseImpl;

  @Autowired
  private ItextService iTextServiceImpl;

  @Autowired
  private CarService carServiceImpl;

  @Autowired
  private SapService sapServiceImpl;

  @Autowired
  private ClientValidator clientValidator;

  @Autowired
  private ServiceEditor serviceEditor;

  @Autowired
  private CarEditor carEditor;

  @InitBinder("orders")
  public void initBinder(WebDataBinder binder) {

    binder.registerCustomEditor(WorkType.class, serviceEditor);
    binder.registerCustomEditor(Car.class, carEditor);
    binder.addValidators(clientValidator);
  }

  @RequestMapping(method = RequestMethod.GET)
  public String getAllType(Model model) {

    model.addAttribute(ITEMSWORKTYPE, workTypeServiceImpl.findAll());
    model.addAttribute(ITEMSCAR, carServiceImpl.findAll());
    model.addAttribute(ORDER, new Orders());
    return "createOrder";
  }

  @RequestMapping(value = "/", method = RequestMethod.POST)
  public String addType(@Validated @ModelAttribute("orders") Orders orders, BindingResult bindingResult, Model model) {

    if (bindingResult.hasErrors()) {
      model.addAttribute(ITEMSWORKTYPE, workTypeServiceImpl.findAll());
      model.addAttribute(ITEMSCAR, carServiceImpl.findAll());
      return "createOrder";
    }
    orders.setCustomer(sapServiceImpl.httpConnectorForSap(orders.getUser_tab()));
    orderServiseImpl.save(orders);
    return "redirect:/?id=" + orders.getId();
  }

  @RequestMapping(value = "/pdf/{id}", method = RequestMethod.GET)
  public void getPDF(HttpServletResponse response, @PathVariable int id) {

    Orders order = orderServiseImpl.findOrderById(id);
    byte[] data = iTextServiceImpl.writeCheck(order);
    String fileName = new SimpleDateFormat(DATAFORMAT).format(new Date()) + ".pdf";
    response.setHeader("Content-Disposition", String.format("inline; filename=\"" + fileName + "\""));
    response.setContentType("application/x-download");
    try (ServletOutputStream outputStream = response.getOutputStream()) {

      response.setContentLength(data.length);
      FileCopyUtils.copy(data, outputStream);

    } catch (NullPointerException | IOException e) {
      LOGGER.error("Con't write date to document", e);
      throw new RuntimeException();
    }
  }

  @RequestMapping(value = "/selectTime", headers = "Accept=*/*", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = "application/json")
  public @ResponseBody String[] selectTimeForDate(@RequestBody String date) {

    List<Orders> orders = orderServiseImpl.findDateOfOrders(date);
    String[] arrTimeOrders = new String[orders.size()];
    for (int i = 0; i < arrTimeOrders.length; i++) {
      arrTimeOrders[i] = orders.get(i).getTime();
    }
    List<String> freeTime = orderServiseImpl.findFreeTime(arrTimeOrders, date);
    String[] arr = freeTime.toArray(new String[freeTime.size()]);
    return arr;
  }

  @RequestMapping(value = "/selectTimeAdmin", headers = "Accept=*/*", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = "application/json")
  public @ResponseBody String[] selectTimeForDateAdmin(@RequestBody TimeDTO timeDTO) {

    Orders order = orderServiseImpl.findOrderById(Integer.parseInt(timeDTO.getId()));
    List<Orders> orders = orderServiseImpl.findDateOfOrders(timeDTO.getDate());
    String[] arrTimeOrders = new String[orders.size()];
    for (int i = 0; i < arrTimeOrders.length; i++) {
      arrTimeOrders[i] = orders.get(i).getTime();
    }
    List<String> freeTime = orderServiseImpl.findFreeTimeForAdmin(arrTimeOrders, timeDTO.getDate(), order);
    String[] arr = freeTime.toArray(new String[freeTime.size()]);
    return arr;
  }

}
