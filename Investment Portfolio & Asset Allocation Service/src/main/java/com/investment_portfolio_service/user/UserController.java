package com.investment_portfolio_service.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
//Testing purpose - create user & list users	

	@Autowired
	private UserService userService;
	
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@PostMapping("createuser")
	public String createUser(@RequestBody User user) {	
		 userService.save(user);
		 return "Success";		
	}
	
	@GetMapping("userlist")
	public List<User> userlist() {
		return userService.userList();		
	}
	
}
