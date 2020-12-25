package com.ashokit.exceptions;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class PhoneBookExceptionHandler {
	
	
	@ExceptionHandler(value=PhoneBookAppException.class)
	public String handlePhoneBookException() {
		return "error";
		
	}

}
