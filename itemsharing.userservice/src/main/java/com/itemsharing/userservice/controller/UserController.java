package com.itemsharing.userservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.itemsharing.userservice.model.User;
import com.itemsharing.userservice.service.UserService;

@RestController
@RequestMapping("/v1/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/{username}")
	public User getUserByUsername(@PathVariable String username) {
		return userService.getUserByUsername(username);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public User createUser(@RequestBody User user) {
		return userService.createUser(user);
	}
}
