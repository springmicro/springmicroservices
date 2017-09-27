package com.itemsharing.itemservice.repository;

import org.springframework.data.repository.CrudRepository;

import com.itemsharing.itemservice.model.User;

public interface UserRepository extends CrudRepository<User, Long>{
	User findByUsername(String username);
}
