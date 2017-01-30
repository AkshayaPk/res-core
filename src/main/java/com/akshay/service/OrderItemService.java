package com.akshay.service;


import com.akshay.dao.OrderItemDAO;

import com.akshay.model.OrderItem;

import com.akshay.validator.OrderItemValidator;

public class OrderItemService {

	
	public void provideService(OrderItem orderItem)
	{
		OrderItemValidator orderItemValidator=new OrderItemValidator();
		OrderItemDAO orderItemDAO=new OrderItemDAO();
		
		if(orderItemValidator.validateSave(orderItem)==true)
		{
			orderItemDAO.save(orderItem);
		}
	}
}
