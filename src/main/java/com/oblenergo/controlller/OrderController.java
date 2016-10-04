package com.oblenergo.controlller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.oblenergo.model.Orders;
import com.oblenergo.service.OrderServise;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;

@Controller
@RequestMapping(value = "/order")
public class OrderController {
        
        @Autowired
        OrderServise orderServiseImpl;
        
        public static final String ITEMS = "order";

	private static final String ORDER = "orders";
        
        @RequestMapping(method = RequestMethod.GET)
        public String getAllOrders(Model model){
            model.addAttribute(ITEMS, orderServiseImpl.findAll());
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
        
}
