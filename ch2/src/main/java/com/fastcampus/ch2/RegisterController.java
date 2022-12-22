package com.fastcampus.ch2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller // ctrl + shift + o
public class RegisterController {
	
	@RequestMapping("/register/add")
	public String register() {
		return "registerForm";
	}
	
	@RequestMapping("/register/save")
	public String save() {
		return "registerInfo";
	}
}
