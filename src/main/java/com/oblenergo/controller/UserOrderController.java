package com.oblenergo.controller;

import com.oblenergo.DTO.TimeDTO;
import com.oblenergo.editor.CarEditor;
import com.oblenergo.editor.ServiceEditor;
import com.oblenergo.model.Car;
import com.oblenergo.model.Orders;
import com.oblenergo.model.WorkType;
import com.oblenergo.service.CarService;
import com.oblenergo.service.ItextService;
import com.oblenergo.service.OrderService;
import com.oblenergo.service.SapService;
import com.oblenergo.validator.ClientValidator;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping(value = "/")
public class UserOrderController {
  Logger LOGGER = Logger.getLogger(UserOrderController.class);

  private static final String WORKTYPE_FROM_SAP = "workTypeFromSap";
  private static final String PDF_FROM_SAP = "PDFfromSap";
  // private static final String ITEMSWORKTYPE = "typeWorks";
  private static final String ITEMSCAR = "cars";
  private static final String ORDER = "orders";
  private static final String DATAFORMAT = "YYYY-MM-DD HH:mm:ss";

  // @Autowired
  // private WorkTypeService workTypeServiceImpl;

  @Autowired
  private OrderService orderServiceImpl;

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
    model.addAttribute(WORKTYPE_FROM_SAP, sapServiceImpl.getAllWorkTypes());
    model.addAttribute(ITEMSCAR, carServiceImpl.findAll());
    model.addAttribute(ORDER, new Orders());
    return "createOrder";
  }

  @RequestMapping(value = "/", method = RequestMethod.POST)
  public String addType(@Validated @ModelAttribute("orders") Orders orders, BindingResult bindingResult, Model model) {

    if (bindingResult.hasErrors()) {
      model.addAttribute(WORKTYPE_FROM_SAP, sapServiceImpl.getAllWorkTypes());
      model.addAttribute(ITEMSCAR, carServiceImpl.findAll());

      return "createOrder";
    }
    orders.setCustomer(sapServiceImpl.getFullNameFromSap(orders.getUser_tab()));
    System.out.println(orders.getWorkType().getId());

    orderServiceImpl.save(orders);
    return "redirect:/?id=" + orders.getId();
  }

  @RequestMapping(value = "/pdf/{id}", method = RequestMethod.GET)
  public void getPDF(HttpServletResponse response, @PathVariable int id) {

    Orders order = orderServiceImpl.findOrderById(id);
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

  @RequestMapping(value = "/selectTimeAdmin", headers = "Accept=*/*", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = "application/json")
  public @ResponseBody String[] selectTimeForDateAdmin(@RequestBody TimeDTO timeDTO) {

    Orders order = orderServiceImpl.findOrderById(Integer.parseInt(timeDTO.getId()));
    List<Orders> orders = orderServiceImpl.findDateOfOrders(timeDTO.getDate());
    String[][] arrTimeOrders = orderServiceImpl.getAllTimeOfOrders(orders);
    List<String> freeTime = orderServiceImpl.findFreeTimeForAdmin(arrTimeOrders, timeDTO.getDate(), order,
        timeDTO.getTimeExecution());

    String[] arr = freeTime.toArray(new String[freeTime.size()]);
    return arr;
  }
}
