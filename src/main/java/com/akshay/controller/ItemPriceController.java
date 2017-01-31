package com.akshay.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.akshay.exception.ItemPriceServiceException;
import com.akshay.model.ItemPrice;
import com.akshay.service.ItemPriceService;

@Controller
@RequestMapping("/ItemPrice")
public class ItemPriceController {
	@RequestMapping("/save")
	public void save(@RequestParam("id") Integer id, @RequestParam("itemName") String itemName,
			@RequestParam("Price") Integer price) {
		Logger log = Logger.getLogger(CategoryController.class.getName());
		System.out.println("ItemPrice Controller called");
		ItemPrice itemPrice = new ItemPrice();
		itemPrice.setId(id);
		itemPrice.setItemName(itemName);
		itemPrice.setPrice(price);
		System.out.println(itemPrice);

		ItemPriceService itemPriceService = new ItemPriceService();
		try {
			itemPriceService.provideService(itemPrice);
		} catch (ItemPriceServiceException e) {
			// TODO Auto-generated catch block
		log.debug("ItemPriceService exception",e);
		}
	}

	public void update(@RequestParam("id") Integer id, @RequestParam("Price") Integer price) {
		Logger log = Logger.getLogger(CategoryController.class.getName());
		System.out.println("ItemPrice Controller called");
		ItemPrice itemPrice = new ItemPrice();
		itemPrice.setId(id);

		itemPrice.setPrice(price);
		System.out.println(itemPrice);

		ItemPriceService itemPriceService = new ItemPriceService();
		try {
			itemPriceService.updateService(itemPrice);
		} catch (ItemPriceServiceException e) {
			// TODO Auto-generated catch block
			log.debug("ItemPriceService Exception",e);
		}
	}

}
