package com.spring.security.SpringSecurityExample.config;

import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class ApplicationConfig extends WebSecurityConfigurerAdapter {

//	@Autowired
//	private PasswordEncoder encoder;
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Bean
	public AuthenticationProvider authenticationProvider() {
		System.out.println("auth provider");
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		provider.setUserDetailsService(userDetailsService);
//		provider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());
		provider.setPasswordEncoder(new BCryptPasswordEncoder());
		return provider;
	}
	
	// InMemoryUser Authentication
//	@Override
//	@Bean
//	protected UserDetailsService userDetailsService() {
//
//		UserDetails user = User.builder().username("ravi").password(encode.encode("1234")).roles("USER").build();
//		UserDetails admin = User.builder().username("ravik").password(encode.encode("123")).roles("ADMIN").build();
//
//		return new InMemoryUserDetailsManager(user, admin);
//	}
	 

	@Override
	protected void configure(HttpSecurity http) throws Exception {

//		 http
//	      .httpBasic().and()
//	      .authorizeRequests()
//	        .antMatchers(HttpMethod.POST, "/api/user/**").hasRole("USER")
//	        .antMatchers(HttpMethod.GET, "/api/user/**").hasRole("USER")
//	        .antMatchers(HttpMethod.PUT, "/api/user/**").hasRole("USER")
//	        .antMatchers(HttpMethod.PATCH, "/api/user/**").hasRole("USER").and()
//	      .csrf().disable();
//	  
		
		http
		.csrf().disable()  											// This is used to allow POST method
		.authorizeRequests()
		.antMatchers("/logoutPage","/public/*")
		.permitAll() 												// This is used to permit the url which is coming from http /
		.antMatchers("/api/user/**").hasRole("USER")				// This will allow access only for USER type role
		.antMatchers("/api/admin/**").hasRole("ADMIN")				// This will allow access only for ADMIN type role
		.anyRequest().authenticated()
		.and()
//		.formLogin(); // This is used to provide login page to authenticate user by user name and password
		.formLogin()
		.loginPage("/login").permitAll()
		.defaultSuccessUrl("/afterLogin", true) //This is used to redirect the page after successful login
		.and()
		.rememberMe() // by default its valid for 14 days 
//		.tokenValiditySeconds((int)TimeUnit.DAYS.toSeconds(21)); // This is used to set remember me validity for 21 days
		.and()
		// below is used to logout a user
		.logout()
		.logoutUrl("/logout") // logout user provided by spring security
		.clearAuthentication(true)  // clear the auth
		.invalidateHttpSession(true) 
		.deleteCookies("JSESSIONID","remember-me")
		.logoutSuccessUrl("/logoutPage");  // after logout redirect to this url page, set it accordingly 
//		.httpBasic();
		
	}

}
