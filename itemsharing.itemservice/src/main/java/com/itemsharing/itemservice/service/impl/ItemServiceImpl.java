package com.itemsharing.itemservice.service.impl;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itemsharing.itemservice.client.UserFeignClient;
import com.itemsharing.itemservice.client.UserRestTemplateClient;
import com.itemsharing.itemservice.model.Item;
import com.itemsharing.itemservice.model.User;
import com.itemsharing.itemservice.repository.ItemRepository;
import com.itemsharing.itemservice.service.ItemService;
import com.itemsharing.itemservice.service.UserService;
import com.itemsharing.itemservice.util.UserContextHolder;

@Service
public class ItemServiceImpl implements ItemService{
	
	private static final Logger LOG = LoggerFactory.getLogger(ItemService.class);
	
	@Autowired
	private ItemRepository itemRepository;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private UserFeignClient userFeignClient;
	
	@Autowired
	private UserRestTemplateClient userRestTemplateClient;
	
	@Override
	public Item addItemByUser(Item item, String username) {
		Item localItem = itemRepository.findByName(item.getName());
		
		if(localItem != null) {
			LOG.info("Item with name {} already exists. Nothing will be done.", item.getName());
			return null;
		} else {
			Date today = new Date();
			item.setAddDate(today);
			
			User user = userService.findByUsername(username);
			item.setUser(user);
			Item newItem = itemRepository.save(item);
			
			return newItem;
		}
	}

	@Override
	public List<Item> getAllItems() {
		
		return (List<Item>) itemRepository.findAll();
	}

	@Override
	public List<Item> getItemsByUsername(String username) {
		User user = userService.findByUsername(username);
		
		return (List<Item>) itemRepository.findByUser(user);
	}

	@Override
	public Item getItemById(Long id) {
		return itemRepository.findOne(id);
	}

	@Override
	public Item updateItem(Item item) throws IOException {
		Item localItem = getItemById(item.getId());
		
		if(localItem == null) {
			throw new IOException ("Item was not found.");
		} else {
			localItem.setName(item.getName());
			localItem.setItemCondition(item.getItemCondition());
			localItem.setStatus(item.getStatus());
			localItem.setDescription(item.getDescription());
			
			return itemRepository.save(localItem);
		}
	}

	@Override
	public void deleteItemById(Long id) {
		itemRepository.delete(id);
	}

	@Override
//	@HystrixCommand(
//			fallbackMethod = "buildFallbackUser",
//			threadPoolKey = "itemByUserThreadPool",
//			threadPoolProperties = {
//					@HystrixProperty(name="coreSize", value = "30"),  
//					//(requests per second at peak when the service is healthy * 99th percentile latency in seconds) + small amount of extra threads for overhead
//					@HystrixProperty(name="maxQueueSize", value="10")
//			}
//	)
	public User getUserByUsername(String username) {
//		return userService.findByUsername(username);
//		randomlyRunLong();
		
		LOG.debug("ItemService.getUserByUsername Correlation id: {}", UserContextHolder.getContext().getCorrelationId());
		
//		return userFeignClient.getUserByUsername(username);
		return userRestTemplateClient.getUser(username);
	}
	
	private void randomlyRunLong() {
		Random rand = new Random();
		int randomNum = rand.nextInt((3-1)+1)+1;
		if (randomNum == 3) sleep();
	}
	
	private void sleep() {
		try {
			Thread.sleep(11000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	private User buildFallbackUser(String username) {
		User user = new User();
		user.setId(123123L);
		user.setUsername("Temp Username");
		
		return user;
	}
}
