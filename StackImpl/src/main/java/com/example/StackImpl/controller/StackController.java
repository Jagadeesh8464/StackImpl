package com.example.StackImpl.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.StackImpl.service.UserService;
import com.example.StackImpl.entity.User;

@RestController
@RequestMapping(value = "/api/user")
public class StackController {

	@Autowired
	UserService userService;

	@PostMapping(value = "/push")
	public List<User> push(@RequestBody User user) {

		return userService.push(user);

	}

	@DeleteMapping(value = "/pop")
	public List<User> pop() {
		
		return userService.pop();
		
	}
	
	
	@GetMapping(value = "/")
	public List<User> getAllUsers() {
		
		return userService.getAllUsers();
		
	}

}
