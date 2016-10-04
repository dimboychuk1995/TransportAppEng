package com.oblenergo.controlller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.oblenergo.model.Orders;
import com.oblenergo.model.WorkType;
import com.oblenergo.service.OrderServise;
import com.oblenergo.service.WorkTypeService;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;


@Controller
@RequestMapping(value = "/")
public class UserOrderController {
        
        public static final String ITEMSORDER = "order";
        
        public static final String ITEMSWORKTYPE = "typeWorks";

	private static final String ORDER = "orders";
        
        private static final String WORK_TYPE = "workType";
        
        @Autowired
	WorkTypeService workTypeServiceImpl;
        
        @Autowired
        OrderServise orderServiseImpl;
        
        @RequestMapping(method = RequestMethod.GET)
	public String getAllType(Model model) {

		model.addAttribute(ITEMSWORKTYPE, workTypeServiceImpl.findAll());
                model.addAttribute(ORDER, new Orders());
		return "createOrder";
	}
        
        @RequestMapping(value = "/", method = RequestMethod.POST)
	public String addType(@Validated @ModelAttribute("orders") Orders orders) {
                System.out.println("I was here");
                orderServiseImpl.save(orders);
                System.out.println("and I was here");
                return "redirect:/";
	} 
}
