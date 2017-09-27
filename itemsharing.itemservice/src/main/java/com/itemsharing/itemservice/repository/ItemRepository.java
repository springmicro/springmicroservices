package com.itemsharing.itemservice.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import com.itemsharing.itemservice.model.Item;
import com.itemsharing.itemservice.model.User;

@Transactional
public interface ItemRepository extends CrudRepository<Item, Long>{
	List<Item> findByUser(User user);
	Item findByName(String name);
}
