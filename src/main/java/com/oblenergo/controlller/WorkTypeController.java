package com.oblenergo.controlller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
		return "workType";
	}

	@RequestMapping(value = "/workType/{id}", method = RequestMethod.POST)
	public String updateType(@ModelAttribute WorkType workType) {
		workTypeServiceImpl.update(workType);
		return "redirect:/";
	}

	@RequestMapping(value = "/workType/{id}", method = RequestMethod.GET)
	public String showTypeById(@PathVariable int id, Model model) {
		model.addAttribute(WORK_TYPE, workTypeServiceImpl.findWorkTypeById(id));
		return "updateCreateWorkType";
	}

	@RequestMapping(value = "/workTypes/newWorkType", method = RequestMethod.GET)
	public String redirectToCreate(Model model) {
		model.addAttribute(WORK_TYPE, new WorkType());

		return "updateCreateWorkType";
	}

	@RequestMapping(value = "/workTypes/newWorkType", method = RequestMethod.POST)
	public String addType(@ModelAttribute WorkType workType) {
		workTypeServiceImpl.save(workType);
		return "redirect:/";
	}

	@RequestMapping(value = "/workType/deleteType/{id}", method = RequestMethod.GET)
	public String deleteType(@PathVariable int id) {
		workTypeServiceImpl.delete(id);
		return "redirect:/";
	}

}
