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
  private WorkTypeService workTypeServiceImpl;

  @Override
  public boolean supports(Class<?> clazz) {
    return WorkType.class.equals(clazz);
  }

  @Override
  public void validate(Object target, Errors errors) {
    WorkType wt = (WorkType) target;
    String regexOnlyNumber = "[0-9]+";
    String idWt = wt.getId();

    if (!idWt.matches(regexOnlyNumber)) {
      errors.rejectValue("id", "Id.Must.Be.Nuber");
    } else if (idWt.length() != 18) {
      errors.rejectValue("id", "Bad.Count.Number");
    } else if (workTypeServiceImpl.getWorkTypeDTOByIdFromSAP(idWt) == null) {
      errors.rejectValue("id", "Not.Have.W.Type");
    } else if (!workTypeServiceImpl.isWorkTypeUnique(wt.getId())) {
      errors.rejectValue("id", "Must.Be.N.Unique");
    }
  }
}
