package com.itemsharing.itemservice.service;

import java.io.IOException;
import java.util.List;

import com.itemsharing.itemservice.model.Item;
import com.itemsharing.itemservice.model.User;


public interface ItemService {
	Item addItemByUser(Item item, String username);
	List<Item> getAllItems();
	List<Item> getItemsByUsername(String username);
	Item getItemById(Long id);
	Item updateItem(Item item) throws IOException;
	void deleteItemById(Long id);
	
	User getUserByUsername(String username);
}
