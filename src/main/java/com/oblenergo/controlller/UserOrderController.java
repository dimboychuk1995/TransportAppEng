package com.oblenergo.controlller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.oblenergo.editor.ServiceEditor;
import com.oblenergo.model.Car;
import com.oblenergo.model.Orders;
import com.oblenergo.model.WorkType;
import com.oblenergo.service.CarService;
import com.oblenergo.service.ItextService;
import com.oblenergo.service.OrderServise;
import com.oblenergo.service.SapService;
import com.oblenergo.service.WorkTypeService;
import com.oblenergo.validator.ClientValidator;

@Controller
@RequestMapping(value = "/")
public class UserOrderController {

	private static final String ITEMSWORKTYPE = "typeWorks";
	private static final String ITEMSCAR = "cars";
	private static final String ORDER = "orders";
	private static final String DATAFORMAT = "YYYY-MM-DD HH:mm:ss";

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

	@Autowired
	ServiceEditor editor;

	@InitBinder("orders")
	public void initBinder(WebDataBinder binder) {

		binder.registerCustomEditor(WorkType.class, editor);
		binder.registerCustomEditor(Car.class, editor);
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
		orderServiseImpl.save(orders);
		return "redirect:/?id=" + orders.getId();
	}

	@RequestMapping(value = "/pdf/{id}", method = RequestMethod.GET)
	public void getPDF(HttpServletResponse response, @PathVariable int id) {

		Orders order = orderServiseImpl.findOrderById(id);
		byte[] data = iTextServiceImpl.writeCheck(order);
		String fileName = new SimpleDateFormat(DATAFORMAT).format(new Date()) + ".pdf";
		response.setHeader("Content-Disposition", String.format("inline; filename=\"" + fileName + "\""));
		response.setContentType("application/x-download");
		try (ServletOutputStream outputStream = response.getOutputStream()) {
			response.setContentLength(data.length);
			FileCopyUtils.copy(data, outputStream);
		} catch (NullPointerException | IOException e) {
			throw new RuntimeException();
		}
	}

	@RequestMapping(value = "/selectTime", headers = "Accept=*/*", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = "application/json")

	public @ResponseBody String[] selectTimeForDate(@RequestBody String date) {
		System.out.println("Date date = " + date);

		List<Orders> orders = orderServiseImpl.findDateOfOrders(date);
		String[] arrTimeOrders = new String[orders.size()];
		for (int i = 0; i < arrTimeOrders.length; i++) {
			arrTimeOrders[i] = orders.get(i).getTime();
		}
		List<String> freeTime = orderServiseImpl.findFreeTime(arrTimeOrders, date);
		String[] arr = freeTime.toArray(new String[freeTime.size()]);
		return arr;
	}

	@RequestMapping(value = "/selectTimeAdmin", headers = "Accept=*/*", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = "application/json")

	public @ResponseBody String[] selectTimeForDateAdmin(@RequestBody String date, String id) {

		Orders order = orderServiseImpl.findOrderById(Integer.parseInt("98"));

		List<Orders> orders = orderServiseImpl.findDateOfOrders(date);

		String[] arrTimeOrders = new String[orders.size()];
		for (int i = 0; i < arrTimeOrders.length; i++) {
			arrTimeOrders[i] = orders.get(i).getTime();
		}

		List<String> freeTime = orderServiseImpl.findFreeTimeForAdmin(arrTimeOrders, date, order);

		String[] arr = freeTime.toArray(new String[freeTime.size()]);
		return arr;
	}

}
