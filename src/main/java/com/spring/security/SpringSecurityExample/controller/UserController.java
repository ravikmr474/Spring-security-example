package com.spring.security.SpringSecurityExample.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.spring.security.SpringSecurityExample.beans.User;

@RestController
@RequestMapping("/api/user/")
public class UserController {
	
	public static Map<Integer, User> users = new HashMap<Integer, User>();

	@RequestMapping(value = "add", method = RequestMethod.POST)
	public String addUser(@RequestBody User user) {
		System.out.println("post method called");
		users.put(user.getId(), user);
		return "Welcome to user page";
	}
	
	@RequestMapping(value = "add")
	public String add() {
		
		return "success";
	}
	
	@RequestMapping(value = "getUser", method = RequestMethod.POST)
	public String getUser() {
		
		
		return "success";
	}

}
