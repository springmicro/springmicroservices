package com.itemsharing.userservice.repository;

import org.springframework.data.repository.CrudRepository;

import com.itemsharing.userservice.model.User;

public interface UserRepository extends CrudRepository<User, Long>{
	User findByUsername(String username);
}
