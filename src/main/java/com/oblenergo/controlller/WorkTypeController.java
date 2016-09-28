package com.oblenergo.controlller;

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

import com.oblenergo.model.WorkType;
import com.oblenergo.service.SapService;
import com.oblenergo.service.WorkTypeService;
import com.oblenergo.validator.WorkTypeValidator;

@Controller
@RequestMapping(value = "/")
public class WorkTypeController {

	public static final String ITEMS = "typeWorks";

	private static final String WORK_TYPE = "workType";

	@Autowired
	WorkTypeService workTypeServiceImpl;

	@Autowired
	SapService sapServiceImpl;

	@Autowired
	WorkTypeValidator workTypeValidator;

	@InitBinder(WORK_TYPE)
	public void initBinder(WebDataBinder binder) {
		binder.addValidators(workTypeValidator);
	}

	@RequestMapping(method = RequestMethod.GET)
	public String getAllType(Model model) {

		model.addAttribute(ITEMS, workTypeServiceImpl.findAll());
		model.addAttribute(WORK_TYPE, new WorkType());
		// sapServiceImpl.httpConnectorForSap("9047");
		return "workType";
	}

	@RequestMapping(value = "/workType/{id}", method = RequestMethod.POST)
	public String updateType(@Validated @ModelAttribute("workType") WorkType workType, BindingResult bindingResult) {

		if (bindingResult.hasErrors()) {
			return "updateCreateWorkType";
		}

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
	public String addType(@Validated @ModelAttribute("workType") WorkType workType, BindingResult bindingResult) {

		if (bindingResult.hasErrors()) {
			return "updateCreateWorkType";
		}
		workTypeServiceImpl.save(workType);
		return "redirect:/";
	}

	@RequestMapping(value = "/delete", method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteBanner(@RequestBody int id) {

		workTypeServiceImpl.delete(id);
	}

}
