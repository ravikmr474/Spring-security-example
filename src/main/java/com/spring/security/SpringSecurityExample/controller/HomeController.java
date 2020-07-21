package com.spring.security.SpringSecurityExample.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping("/api/")
public class HomeController {

	@RequestMapping("/hello")
	public String hello() {
		
		return "Java World";
	}
	
//	@RequestMapping("/")
//	public String home() {
//		
//		return "Welcome to spring security";
//	}
	
	@RequestMapping("/public/hello")
	public String publicUser() {
		
		return "Welcome to public page";
	}
	
	@RequestMapping("/private/hello")
	public String privateUser() {
		
		return "Welcome to private page";
	}
}
