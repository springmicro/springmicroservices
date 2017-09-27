package com.itemsharing.userservice.service;

import com.itemsharing.userservice.model.User;

public interface UserService {
	User createUser(User user);
	
	User getUserByUsername(String username);
}
