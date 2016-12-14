package com.oblenergo.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.oblenergo.DTO.TimeDTO;
import com.oblenergo.DTO.WorkTypeDTO;
import com.oblenergo.editor.CarEditor;
import com.oblenergo.editor.ServiceEditor;
import com.oblenergo.model.Car;
import com.oblenergo.model.Orders;
import com.oblenergo.model.WorkType;
import com.oblenergo.service.CarService;
import com.oblenergo.service.OrderService;
import com.oblenergo.service.SapService;
import com.oblenergo.service.WorkTypeService;
import com.oblenergo.validator.OrderValidator;

@Controller
@RequestMapping(value = "/")
public class UserOrderController {
  Logger LOGGER = Logger.getLogger(UserOrderController.class);

  private static final String WORKTYPE_FROM_SAP = "workTypeFromSap";
  // private static final String ITEMSWORKTYPE = "typeWorks";
  private static final String ITEMSCAR = "cars";
  private static final String ORDER = "orders";

  // @Autowired
  // private WorkTypeService workTypeServiceImpl;

  @Autowired
  private OrderService orderServiceImpl;

  @Autowired
  private CarService carServiceImpl;

  @Autowired
  private SapService sapServiceImpl;

  @Autowired
  private WorkTypeService wokrTypeServiceImpl;

  @Autowired
  private OrderValidator orderValidator;

  @Autowired
  private ServiceEditor serviceEditor;

  @Autowired
  private CarEditor carEditor;

  @InitBinder("orders")
  public void initBinder(WebDataBinder binder) {

    binder.registerCustomEditor(WorkType.class, serviceEditor);
    binder.registerCustomEditor(Car.class, carEditor);
    binder.addValidators(orderValidator);
  }

  @RequestMapping(method = RequestMethod.GET)
  public String getAllType(Model model) {
    model.addAttribute(WORKTYPE_FROM_SAP, wokrTypeServiceImpl.findAvailableWorkType(sapServiceImpl.getAllWorkTypes()));// sapServiceImpl.getAllWorkTypes());
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

    List<WorkTypeDTO> allWorkTypes = sapServiceImpl.getAllWorkTypes();

    String all_sum = null;
    for (WorkTypeDTO list : allWorkTypes) {
      if (list.getId().equals(orders.getWorkType().getId())) {
        all_sum = list.getPrice();
      }
      break;
    }
    double all_sumWithPDV = Double.parseDouble(all_sum);
    all_sumWithPDV = all_sumWithPDV * 1.2;
    all_sum = Double.toString(all_sumWithPDV);
    orders.setAll_sum(all_sum);
    orderServiceImpl.save(orders);

    return "redirect:/?id=" + orders.getId();
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
