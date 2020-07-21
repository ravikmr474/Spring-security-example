package com.spring.security.SpringSecurityExample.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {

	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String getLoginPage() {
		System.out.println(" GET Login called");
		return "login";
	}
	
//	@RequestMapping(value="/login" ,method=RequestMethod.POST)
//	public String postLoginPage() {
//		System.out.println(" POST Login called");
//		return "success";
//	}
	
	@RequestMapping(value="/afterLogin")
	public String signIn() {
		System.out.println("afterLogin called");
		return "success";
	}
	
	@RequestMapping(value="/logoutPage")
	public String logoutPage() {
		System.out.println("afterLogin called");
		return "logout";
	}
}
