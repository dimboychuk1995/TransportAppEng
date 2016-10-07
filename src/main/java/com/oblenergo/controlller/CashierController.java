package com.oblenergo.controlller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.oblenergo.model.Notification;
import com.oblenergo.model.OrderMessage;
import com.oblenergo.service.OrderServise;

@Controller
public class CashierController {
    
    private static final String ORDER_LIST = "orders";
    
    @Autowired
    OrderServise orderServiceImpl;
    
    @RequestMapping(value="/cashier",method=RequestMethod.GET)
    public String getCashierPage(Model model) { 
        model.addAttribute(ORDER_LIST, orderServiceImpl.findAll());
        return "cashier";      
    }
    
    @MessageMapping("/newOrder")
    @SendTo("/adminNotification")
    public Notification greeting(OrderMessage orderMessage) {
        return new Notification(orderMessage.getMessage());
    }

}
