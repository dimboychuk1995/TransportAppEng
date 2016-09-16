package com.oblenergo.controlller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.oblenergo.model.WorkType;
import com.oblenergo.service.WorkTypeService;

@Controller
@RequestMapping(value = "/")
public class WorkTypeController {

	@Autowired
	WorkTypeService workTypeServiceImpl;

	public static final String ITEMS = "typeWorks";

	private static final String WORK_TYPE = "workType";

	@RequestMapping(method = RequestMethod.GET)
	public String getAllType(Model model) {
		model.addAttribute(ITEMS, workTypeServiceImpl.findAll());
		model.addAttribute(WORK_TYPE, new WorkType());
		return "workTypePage";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String addType(@ModelAttribute WorkType workType) {

		workTypeServiceImpl.save(workType);
		return "redirect:/";
	}

}
