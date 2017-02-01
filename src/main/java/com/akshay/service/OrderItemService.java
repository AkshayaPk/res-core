package com.akshay.service;

import com.akshay.dao.OrderItemDAO;
import com.akshay.exception.OrderItemInvalidEntriesException;
import com.akshay.exception.OrderItemServiceException;
import com.akshay.model.OrderItem;

import com.akshay.validator.OrderItemValidator;

public class OrderItemService {

	public void provideService(OrderItem orderItem) throws OrderItemServiceException {
		OrderItemValidator orderItemValidator = new OrderItemValidator();
		OrderItemDAO orderItemDAO = new OrderItemDAO();

		try {
			orderItemValidator.validateSave(orderItem);
			orderItemDAO.save(orderItem);
		} catch (OrderItemInvalidEntriesException e) {
			throw new OrderItemServiceException("OrderItem Service Exception caught",e);
		}
	}
}
