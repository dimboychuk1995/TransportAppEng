package com.oblenergo.controlller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.oblenergo.editor.ServiceEditor;
import com.oblenergo.model.Orders;
import com.oblenergo.service.CarService;
import com.oblenergo.service.ItextService;
import com.oblenergo.service.OrderServise;
import com.oblenergo.service.SapService;
import com.oblenergo.service.WorkTypeService;
import com.oblenergo.validator.ClientValidator;

@Controller
@RequestMapping(value = "/")
public class UserOrderController {

	public static final String ITEMSORDER = "order";
	public static final String ITEMSWORKTYPE = "typeWorks";
	public static final String ITEMSCAR = "cars";
	private static final String ORDER = "orders";
	private static final String WORK_TYPE = "workType";
	private static final String CAR = "car";

	@Autowired
	WorkTypeService workTypeServiceImpl;

	@Autowired
	OrderServise orderServiseImpl;

	@Autowired
	ItextService iTextServiceImpl;

	@Autowired
	CarService carServiceImpl;

	@Autowired
	SapService sapServiceImpl;
	@Autowired
	ClientValidator clientValidator;

	@InitBinder(ORDER)
	public void initBinder(WebDataBinder binder) {
		binder.addValidators(clientValidator);
	}

	@RequestMapping(method = RequestMethod.GET)
	public String getAllType(Model model) {

		model.addAttribute(ITEMSWORKTYPE, workTypeServiceImpl.findAll());
		model.addAttribute(ITEMSCAR, carServiceImpl.findAll());
		model.addAttribute(ORDER, new Orders());
		return "createOrder";
	}

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String addType(@Validated @ModelAttribute("orders") Orders orders, BindingResult bindingResult,
			Model model) {

		if (bindingResult.hasErrors()) {
			model.addAttribute(ITEMSWORKTYPE, workTypeServiceImpl.findAll());
			model.addAttribute(ITEMSCAR, carServiceImpl.findAll());
			return "createOrder";
		}
		orders.setCustomer(sapServiceImpl.httpConnectorForSap(orders.getUser_tab()));
		System.out.println(orders.getTime());
		System.out.println(orders.getDate());
		orderServiseImpl.save(orders);
		iTextServiceImpl.writeCheck(orders);
		return "redirect:/";

	}

	@Autowired
	ServiceEditor editor;

	// @InitBinder("orders")
	// public void initBinder(WebDataBinder binder) {
	// binder.registerCustomEditor(WorkType.class, editor);
	//
	// }
	//
	// @InitBinder("orders")
	// public void initBinderCar(WebDataBinder binder) {
	// binder.addValidators(clientValidator);
	// binder.registerCustomEditor(Car.class, editor);
	// }

	@RequestMapping(value = "/selectTime", headers = "Accept=*/*", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = "application/json")

	public @ResponseBody String[] selectTimeForDate(@RequestBody String date) {

		List<Orders> orders = orderServiseImpl.findDateOfOrders(date);

		String[] arrTimeOrders = new String[orders.size()];

		for (int i = 0; i < arrTimeOrders.length; i++) {
			arrTimeOrders[i] = orders.get(i).getTime();
		}

		List<String> freeTime = orderServiseImpl.findFreeTime(arrTimeOrders, date);
		String[] arr = freeTime.toArray(new String[freeTime.size()]);

		return arr;
	}

}
