package com.oblenergo.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.oblenergo.model.WorkType;
import com.oblenergo.service.WorkTypeService;

@Component
public class WorkTypeValidator implements Validator {

	@Autowired
	WorkTypeService workTypeServiceImpl;

	@Override
	public boolean supports(Class<?> clazz) {
		return WorkType.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		WorkType wt = (WorkType) target;
		String name = wt.getName();
		Integer id = wt.getId();

		if (!workTypeServiceImpl.isWorkTypeUnique(name, id)) {
			errors.rejectValue("name", "Must.Be.N.Unique");
		}

	}

}
