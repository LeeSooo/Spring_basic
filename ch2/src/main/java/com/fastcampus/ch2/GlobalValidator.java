package com.fastcampus.ch2;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class GlobalValidator implements Validator {
	@Override
	public boolean supports(Class<?> clazz) {
//			return User.class.equals(clazz); // 검증하려는 객체가 User타입인지 확인
		return User.class.isAssignableFrom(clazz); // clazz가 User 또는 그 자손인지 확인
	}

	@Override
	public void validate(Object target, Errors errors) { 
		System.out.println("GlobalValidator.validate() is called");

		User user = (User)target;
		
		String id = user.getId();
		
//		if(id==null || "".equals(id.trim())) {
//			errors.rejectValue("id", "required");
//		} 이 코드 내용과 밑의 코드 내용이 실행 결과는 동일
		
		// 내용이 비어있거나 null인 경우, required로 저장해라.
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "id",  "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "pwd", "required");
		
		// 아이디의 길이 관련 코드
		if(id==null || id.length() <  5 || id.length() > 12) {
			errors.rejectValue("id", "invalidLength", new String[]{"", "5","12"}, null);
		}
	}
}
