package com.akshay.validator;


import com.akshay.model.ItemPrice;

public class TestItemPriceValidator {

	public static void main(String[] args) {
		
		ItemPrice itemPrice = new ItemPrice();
		itemPrice.setPrice(-1);
		ItemPriceValidator itemPriceValidator=new ItemPriceValidator();
		itemPriceValidator.validateUpdate(itemPrice);
	}

}
