package com.akshay.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.akshay.exception.ItemServiceException;
import com.akshay.model.Category;
import com.akshay.model.Item;
import com.akshay.service.ItemService;

@Controller
@RequestMapping("/Item")
public class ItemController {
	@RequestMapping("/save")
	public void save(@RequestParam("id") Integer id, @RequestParam("itemName") String itemName,
			@RequestParam("categoryCode") Integer categoryCode, @RequestParam("itemOpeningStock") Integer itemOpenStock,
			@RequestParam("itemStockOnHand") Integer itemStockOnHand,
			@RequestParam("itemClosingStock") Integer itemClosingStock) {
		Logger log = Logger.getLogger(CategoryController.class.getName());
		Item item = new Item();
		item.setId(id);
		item.setItemName(itemName);
		Category category = new Category();
		category.setId(categoryCode);
		item.setCategoryCode(category);
		item.setItemOpeningStock(itemOpenStock);
		item.setItemStockOnHand(itemStockOnHand);
		item.setItemClosingStock(itemClosingStock);

		ItemService itemService = new ItemService();
		try {
			itemService.provideService(item);
		} catch (ItemServiceException e) {
			log.debug("ItemController save exception", e);
		}
	}

	public void update(@RequestParam("id") Integer id, @RequestParam("itemName") String itemName) {
		Logger log = Logger.getLogger(CategoryController.class.getName());
		Item item = new Item();
		item.setId(id);
		item.setItemName(itemName);

		ItemService itemService = new ItemService();
		try {
			itemService.updateService(item);
		} catch (ItemServiceException e) {
			log.debug("ItemController update exception", e);
		}
	}
}
