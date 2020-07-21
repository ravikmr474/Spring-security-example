package com.spring.security.SpringSecurityExample.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/public/user/")
public class PublicController {

	@RequestMapping("index")
	public String publicPage() {
		return "Welcome to public page";
	}
}
