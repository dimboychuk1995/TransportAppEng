package com.oblenergo.controlller;

import com.oblenergo.editor.ServiceEditor;
import com.oblenergo.model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.oblenergo.model.Orders;
import com.oblenergo.model.WorkType;
import com.oblenergo.service.CarService;
import com.oblenergo.service.OrderServise;
import java.util.List;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

@Controller
@RequestMapping(value = "/order")
public class OrderController {
        
        @Autowired
        OrderServise orderServiseImpl;
        
        @Autowired
        CarService carServiceImpl;
        
        public static final String ITEMSCAR = "cars";
        
        public static final String ITEMS = "order";

	private static final String ORDER = "orders";
        
        @RequestMapping(method = RequestMethod.GET)
        public String getAllOrders(Model model){
            model.addAttribute(ITEMS, orderServiseImpl.findAll());
            model.addAttribute(ITEMSCAR, carServiceImpl.findAll());
            model.addAttribute(ORDER, new Orders());
            return "order";
        }
        
        @RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public String showTypeById(@PathVariable int id, Model model) {
		model.addAttribute(ORDER, orderServiseImpl.findOrderById(id));
		return "updateCreateOrders";
	}
        
        @RequestMapping(value = "/{id}", method = RequestMethod.POST)
        public String updateOrder(@ModelAttribute Orders orders){
            orderServiseImpl.update(orders);
            return "redirect:/order";
        }
        
        @RequestMapping(value="/newOrder", method = RequestMethod.GET)
        public String redirectToCreate(Model model){
                model.addAttribute(ORDER, new Orders());
                return "updateCreateOrders";
        }
        
        @RequestMapping(value = "/newOrder", method = RequestMethod.POST)
	public String addType(@Validated @ModelAttribute("orders") Orders orders, BindingResult bindingResult) {
            
                if (bindingResult.hasErrors()) {
                        return "updateCreateOrders";
                }
                orderServiseImpl.save(orders);
                return "redirect:/order";
	}

        
        @RequestMapping(value = "/deleteOrder/{id}", method = RequestMethod.GET)
	public String deleteType(@PathVariable int id) {
		orderServiseImpl.delete(id);
		return "redirect:/order";
	}
        
        
        @Autowired
        ServiceEditor editor;
        
        @InitBinder("orders")
        public void initBinder(WebDataBinder binder) {
                binder.registerCustomEditor(WorkType.class, editor);        
        }
        
        @InitBinder("orders")
        public void initBinderCar(WebDataBinder binder) {
                binder.registerCustomEditor(Car.class, editor);
        }
        
}
