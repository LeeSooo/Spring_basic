package com.fastcampus.ch2;

import java.io.FileNotFoundException;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice("com.fastcampus.ch3")		// 지정된 패키지에서 발생한 예외만 처리
//@ControllerAdvice() - 모든 페키지에서 발생한 예외 적용
public class GlobalCather {
	@ExceptionHandler({NullPointerException.class, FileNotFoundException.class})	
	public String catcher2(Exception ex, Model m ) {
		System.out.println("catcher() in ExceptionController");
		m.addAttribute("ex", ex);
		return "error";
	}
	
	@ExceptionHandler(Exception.class)	
	public String catcher(Exception ex, Model m) {
		m.addAttribute("ex", ex);
		return "error";
	}
}
