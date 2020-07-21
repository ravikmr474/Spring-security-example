package com.spring.security.SpringSecurityExample.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/admin/")
public class AdminController {

	@RequestMapping("add")
	public String addAdmin() {
		
		return "Welcome to admin page";
	}
}
