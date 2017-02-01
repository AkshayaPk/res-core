package com.akshay.service;

import com.akshay.dao.OrderDAO;
import com.akshay.exception.OrderEntriesInvalidException;
import com.akshay.exception.OrderServiceException;
import com.akshay.model.Order;

import com.akshay.validator.OrderValidator;

public class OrderService {

	public void provideService(Order order) throws OrderServiceException {
		OrderValidator orderValidator = new OrderValidator();
		OrderDAO orderDAO = new OrderDAO();
		try {
			orderValidator.validateSave(order);
			orderDAO.save(order);
		} catch (OrderEntriesInvalidException e) {
			throw new OrderServiceException("OrderService exception caught",e);
		}
	}
}
