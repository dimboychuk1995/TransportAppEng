package com.oblenergo.controlller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.oblenergo.service.WorkTypeService;

@Controller
@RequestMapping(value = "/")
public class WorkTypeController {

	@Autowired
	WorkTypeService itemServiceImpl;

	public static final String ITEMS = "typeWorks";

	@RequestMapping(method = RequestMethod.GET)
	public String getAllType(Model model) {
		model.addAttribute(ITEMS, itemServiceImpl.findAll());
		return "WorkTypePage";
	}

}
