package com.oblenergo.validator;

public class ClientValidator {

}
//@Component
//public class ClientValidator implements Validator {
//
//	@Autowired
//	SapService sapServiceImpl;
//
//	@Override
//	public boolean supports(Class<?> clazz) {
//
//		return TabNumber.class.equals(clazz);
//	}
//
//	@Override
//	public void validate(Object target, Errors errors) {
//
//		TabNumber tn = (TabNumber) target;
//      String tabNumber = tn.getTabNumber1();
//		if (tabNumber != null && tabNumber != "" && tabNumber.length() <=5) {
//
//			if (!tn.getTabNumber1().matches("\\d+")) {
//				errors.rejectValue("tabNumber1", "Must.be.number");
//			} else {
//				String fullName = sapServiceImpl.httpConnectorForSap(tn.getTabNumber1());
//				if (fullName == null) {
//					errors.rejectValue("tabNumber1", "No.such.tabnamber");
//				}
//			}
//
//		}
//	}
//
//}
