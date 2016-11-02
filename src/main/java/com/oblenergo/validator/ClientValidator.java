package com.oblenergo.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

    String regexPattern = "([1][0-7]):[0-5][0-9]";
    Orders tn = (Orders) target;
    String tabNumber = tn.getUser_tab();
    String time = tn.getTime();
    String timeEnd = tn.getTime_end();

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

    if (!checkTime(regexPattern, time)) {
      errors.rejectValue("time", "Bad.time");
    }

    if (!checkTime(regexPattern, timeEnd)) {
      errors.rejectValue("time_end", "Bad.time");
    }

  }

  public boolean checkTime(String regex, String time) {
    Pattern p = Pattern.compile(regex);
    Matcher m = p.matcher(time);
    if (m.find()) {
      return true;
    } else {
      return false;
    }
  }

}
