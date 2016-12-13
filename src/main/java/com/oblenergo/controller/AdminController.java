package com.oblenergo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.oblenergo.DTO.OrderDTO;
import com.oblenergo.editor.CarEditor;
import com.oblenergo.editor.ServiceEditor;
import com.oblenergo.enums.StatusOrderEnum;
import com.oblenergo.model.Car;
import com.oblenergo.model.Orders;
import com.oblenergo.model.WorkType;
import com.oblenergo.service.CarService;
import com.oblenergo.service.MailService;
import com.oblenergo.service.OrderService;
import com.oblenergo.service.SapService;
import com.oblenergo.service.WorkTypeService;
import com.oblenergo.validator.WorkTypeValidator;

@Controller
@RequestMapping(value = "/admin")
public class AdminController {

  private static final String ITEMSWORKTYPE = "typeWorks";
  private static final String ITEMSORDER = "order";
  private static final String ITEMSCAR = "cars";
  private static final String WORK_TYPE = "workType";
  private static final String ORDER = "orders";
  private static final String STATUS_ORDER_ENUM = "items";
  private static final String WORKTYPE_FROM_SAP = "workTypeFromSap";

  @Autowired
  private MailService mailServiceImpl;

  @Autowired
  private OrderService orderServiceImpl;

  @Autowired
  private CarService carServiceImpl;

  @Autowired
  private WorkTypeService workTypeServiceImpl;

  @Autowired
  private ServiceEditor serviceEditor;

  @Autowired
  private CarEditor carEditor;

  @Autowired
  private SapService sapServiceImpl;

  @Autowired
  private WorkTypeValidator workTypeValidator;

  @InitBinder(WORK_TYPE)
  public void initBinder(WebDataBinder binder) {
    binder.addValidators(workTypeValidator);
  }

  @InitBinder(ORDER)
  public void initBinderOrder(WebDataBinder binder) {
    binder.registerCustomEditor(WorkType.class, serviceEditor);
    binder.registerCustomEditor(Car.class, carEditor);
  }

  @RequestMapping(method = RequestMethod.GET)
  public String getAllType(Model model) {

    model.addAttribute(ITEMSWORKTYPE, workTypeServiceImpl.findAll());
    model.addAttribute(WORK_TYPE, new WorkType());
    return "workType";
  }

  @RequestMapping(value = "/workType/{id}", method = RequestMethod.POST)
  public String updateType(@Validated @ModelAttribute("workType") WorkType workType, BindingResult bindingResult) {

    if (bindingResult.hasErrors()) {
      return "updateCreateWorkType";
    }

    workTypeServiceImpl.update(workType);
    return "redirect:/admin";
  }

  // @RequestMapping(value = "/workType/{id}", method = RequestMethod.GET)
  // public String showTypeById(@PathVariable int id, Model model) {
  //
  // model.addAttribute(WORK_TYPE, workTypeServiceImpl.findWorkTypeById(id));
  // return "updateCreateWorkType";
  // }

  @RequestMapping(value = "/workType/newWorkType", method = RequestMethod.GET)
  public String redirectToCreate(Model model) {

    model.addAttribute(WORK_TYPE, new WorkType());
    return "updateCreateWorkType";
  }

  @RequestMapping(value = "/workType/newWorkType", method = RequestMethod.POST)
  public String addType(@Validated @ModelAttribute("workType") WorkType workType, BindingResult bindingResult) {

    if (bindingResult.hasErrors()) {
      return "updateCreateWorkType";
    }
    workTypeServiceImpl.save(workType);
    return "redirect:/admin";
  }

  @RequestMapping(value = "/delete", method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_VALUE)
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void deleteWorkType(@RequestBody int id) {

    workTypeServiceImpl.delete(id);
  }

  @RequestMapping(value = "/order", method = RequestMethod.GET)
  public String getAllOrders(Model model) {
    model.addAttribute(ITEMSORDER, orderServiceImpl.findAll());
    model.addAttribute(ORDER, new Orders());
    return "order";
  }

  @RequestMapping(value = "/order/{id}", method = RequestMethod.GET)
  public String showTypeOrderById(@PathVariable int id, Model model) {
    model.addAttribute(ORDER, orderServiceImpl.findOrderById(id));
    model.addAttribute(ITEMSWORKTYPE, workTypeServiceImpl.findAll());
    model.addAttribute(ITEMSCAR, carServiceImpl.findAll());
    model.addAttribute(STATUS_ORDER_ENUM, StatusOrderEnum.values());
    model.addAttribute(WORKTYPE_FROM_SAP, sapServiceImpl.getAllWorkTypes());
    return "updateCreateOrders";
  }

  @RequestMapping(value = "/order/{id}", method = RequestMethod.POST)
  public String updateOrder(@Validated @ModelAttribute("orders") Orders orders,  BindingResult bindingResult,
      Model model) {


    System.out.println(sapServiceImpl.getUserEmailFromSap("9522"));
    System.out.println();
    System.out.println();
    System.out.println();
    System.out.println();
    if (bindingResult.hasErrors()) {
      model.addAttribute(ORDER, orderServiceImpl.findOrderById(orders.getId()));
      model.addAttribute(ITEMSWORKTYPE, workTypeServiceImpl.findAll());
      model.addAttribute(ITEMSCAR, carServiceImpl.findAll());
      model.addAttribute(STATUS_ORDER_ENUM, StatusOrderEnum.values());
      model.addAttribute(WORKTYPE_FROM_SAP, sapServiceImpl.getAllWorkTypes());
      return "updateCreateOrders";
    }

    if(orders.getStatus_order().equals(StatusOrderEnum.DONE) &&
            (!orderServiceImpl.findOrderById(orders.getId()).getStatus_order().equals(orders.getStatus_order()))) {
      OrderDTO orderDTO = sapServiceImpl.createNewOrder(orders.getCar_number(), orders.getWorkType().getId(), Integer.toString(orders.getCount()));
      mailServiceImpl.sendMail(orderDTO, sapServiceImpl.getUserEmailFromSap(orders.getUser_tab()), "Your order is confirmed");
    }

    if(orders.getStatus_order().equals(StatusOrderEnum.CANCELED)) {
      mailServiceImpl.sendMailWithoutPDF(sapServiceImpl.getUserEmailFromSap(orders.getUser_tab()), "Your order is CANCELED");
    }

    orderServiceImpl.update(orders);
    return "redirect:/admin/order";
  }

  @RequestMapping(value = "/order/delete", method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_VALUE)
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void deleteType(@RequestBody int id) {
    orderServiceImpl.delete(id);
  }

}
