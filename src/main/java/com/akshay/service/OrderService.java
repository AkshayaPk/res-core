package com.akshay.service;

import com.akshay.dao.OrderDAO;

import com.akshay.model.Order;

import com.akshay.validator.OrderValidator;

public class OrderService {

	public void provideService(Order order) {
		OrderValidator orderValidator = new OrderValidator();
		OrderDAO orderDAO = new OrderDAO();
		if (orderValidator.validateSave(order) == true) {
			orderDAO.save(order);
		}
	}
}
