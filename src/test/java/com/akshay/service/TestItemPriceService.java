package com.akshay.service;

import com.akshay.exception.ItemPriceServiceException;
import com.akshay.model.ItemPrice;

public class TestItemPriceService {
	public static void main(String[] args) {
   ItemPriceService itemPriceService=new ItemPriceService();
   ItemPrice itemPrice = new ItemPrice();
   itemPrice.setId(15);
   try {
	itemPriceService.deleteService(itemPrice);
} catch (ItemPriceServiceException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
	}
}
