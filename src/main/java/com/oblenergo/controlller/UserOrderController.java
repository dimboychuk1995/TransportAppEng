package com.oblenergo.controlller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.oblenergo.editor.ServiceEditor;
import com.oblenergo.model.Car;
import com.oblenergo.model.Orders;
import com.oblenergo.model.WorkType;
import com.oblenergo.service.CarService;
import com.oblenergo.service.OrderServise;
import com.oblenergo.service.WorkTypeService;

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
	CarService carServiceImpl;

	@RequestMapping(method = RequestMethod.GET)
	public String getAllType(Model model) {
		model.addAttribute(ITEMSORDER, orderServiseImpl.findAll());
		model.addAttribute(ITEMSWORKTYPE, workTypeServiceImpl.findAll());
		model.addAttribute(ITEMSCAR, carServiceImpl.findAll());
		model.addAttribute(ORDER, new Orders());
		return "createOrder";
	}

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String addType(@Validated @ModelAttribute("orders") Orders orders) {
		orderServiseImpl.save(orders);
		return "redirect:/";
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
