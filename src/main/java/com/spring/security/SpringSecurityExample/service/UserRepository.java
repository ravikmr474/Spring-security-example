package com.spring.security.SpringSecurityExample.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.spring.security.SpringSecurityExample.beans.User;

@Service
public interface UserRepository extends JpaRepository<User, Integer>{

	User findByUsername(String username);
	
}
