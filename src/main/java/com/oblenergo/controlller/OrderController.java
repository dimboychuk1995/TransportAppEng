package com.oblenergo.controlller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;

import com.oblenergo.editor.ServiceEditor;
import com.oblenergo.model.Car;
import com.oblenergo.model.WorkType;
import com.oblenergo.service.CarService;
import com.oblenergo.service.OrderServise;
import com.oblenergo.service.WorkTypeService;

@Controller
@RequestMapping(value = "/order")
public class OrderController {

	public static final String ITEMSCAR = "cars";
	public static final String ITEMS = "order";
	public static final String ITEMSWORKTYPE = "typeWorks";
	private static final String ORDER = "orders";
	private static final String STATUS_ORDER_ENUM = "items";

	@Autowired
	OrderServise orderServiseImpl;

	@Autowired
	CarService carServiceImpl;

	@Autowired
	WorkTypeService workTypeServiceImpl;

	@Autowired
	ServiceEditor editor;

	@InitBinder("orders")
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(WorkType.class, editor);
		binder.registerCustomEditor(Car.class, editor);
	}

}
