package com.oblenergo.controlller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.oblenergo.editor.ServiceEditor;
import com.oblenergo.enums.StatusOrderEnum;
import com.oblenergo.model.Car;
import com.oblenergo.model.Orders;
import com.oblenergo.model.WorkType;
import com.oblenergo.service.CarService;
import com.oblenergo.service.OrderServise;
import com.oblenergo.service.WorkTypeService;

@Controller
@RequestMapping(value = "/order")
public class OrderController {
    
    public static final String ITEMSCAR = "cars";
    public static final String ITEMS = "order";
    public static final String ITEMSWORKTYPE = "typeWorks";
    private static final String ORDER = "orders";
    private static final String STATUS_ORDER_ENUM = "items";

    @Autowired
    OrderServise orderServiseImpl;

    @Autowired
    CarService carServiceImpl;

    @Autowired
    WorkTypeService workTypeServiceImpl;
    
    @Autowired
    ServiceEditor editor;

    @InitBinder("orders")
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(WorkType.class, editor);
        binder.registerCustomEditor(Car.class, editor);
    }

    @RequestMapping(method = RequestMethod.GET)
    public String getAllOrders(Model model) {
        model.addAttribute(ITEMS, orderServiseImpl.findAll());
        model.addAttribute(ORDER, new Orders());
        return "order";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String showTypeById(@PathVariable int id, Model model) {
        model.addAttribute(ORDER, orderServiseImpl.findOrderById(id));
        model.addAttribute(ITEMSWORKTYPE, workTypeServiceImpl.findAll());
        model.addAttribute(ITEMSCAR, carServiceImpl.findAll());
        model.addAttribute(STATUS_ORDER_ENUM, StatusOrderEnum.values());
        return "updateCreateOrders";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.POST)
    public String updateOrder(@ModelAttribute Orders orders, Model model) {
        model.addAttribute(ITEMS, orderServiseImpl.findAll());
        orderServiseImpl.update(orders);
        return "redirect:/order";
    }

    @RequestMapping(value = "/newOrder", method = RequestMethod.GET)
    public String redirectToCreate(Model model) {
        model.addAttribute(ORDER, new Orders());
        model.addAttribute(ITEMSWORKTYPE, workTypeServiceImpl.findAll());
        model.addAttribute(ITEMSCAR, carServiceImpl.findAll());
        model.addAttribute(STATUS_ORDER_ENUM, StatusOrderEnum.values());
        return "updateCreateOrders";
    }

    @RequestMapping(value = "/newOrder", method = RequestMethod.POST)
    public String addType(@Validated @ModelAttribute("orders") Orders orders, BindingResult bindingResult) {
        orderServiseImpl.save(orders);
        return "redirect:/order";
    }

    @RequestMapping(value = "/deleteOrder/{id}", method = RequestMethod.GET)
    public String deleteType(@PathVariable int id) {
        orderServiseImpl.delete(id);
        return "redirect:/order";
    }

}
