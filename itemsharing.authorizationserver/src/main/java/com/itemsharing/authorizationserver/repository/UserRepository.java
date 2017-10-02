package com.itemsharing.authorizationserver.repository;

import org.springframework.data.repository.CrudRepository;

import com.itemsharing.authorizationserver.model.User;

public interface UserRepository extends CrudRepository<User, Long>{
	
	User findByUsername(String username);
}
