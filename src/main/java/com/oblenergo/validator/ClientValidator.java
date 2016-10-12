package com.oblenergo.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.oblenergo.model.Orders;
import com.oblenergo.service.SapService;

@Component
public class ClientValidator implements Validator {

	@Autowired
	SapService sapServiceImpl;

	@Override
	public boolean supports(Class<?> clazz) {

		return Orders.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {

		Orders tn = (Orders) target;
		String tabNumber = tn.getUser_tab();
		if (tabNumber != null && tabNumber != "" && tabNumber.length() <= 5) {

			if (!tn.getUser_tab().matches("\\d+")) {
				errors.rejectValue("user_tab", "Must.be.number");
			} else {
				String fullName = sapServiceImpl.httpConnectorForSap(tn.getUser_tab());
				if (fullName == null) {
					errors.rejectValue("user_tab", "No.such.tabnamber");
				}
			}

		}
	}

}
