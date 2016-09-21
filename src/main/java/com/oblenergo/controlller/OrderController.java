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

@Controller
@RequestMapping(value = "/")
public class OrderController {
        
        @Autowired
        OrderServise orderServiseImpl;
        
        public static final String ITEMS = "order";

	private static final String ORDER = "order";
        
        @RequestMapping(method = RequestMethod.GET)
        public String getAllOrders(Model model){
            model.addAttribute(ITEMS, orderServiseImpl.findAll());
            model.addAttribute(ORDER, new Orders());
            return "orders";
        }
        
}
