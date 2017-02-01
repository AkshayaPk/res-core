package com.akshay.validator;

import com.akshay.exception.OrderEntriesInvalidException;
import com.akshay.model.Order;

public class OrderValidator {
	public void validateSave(Order order) throws OrderEntriesInvalidException {

		if ("".equals(order.getOrderNo()) || "".equals(order.getOrderDate()) || "".equals(order.getOrderTime())
				|| "".equals(order.getOrderSeatNo())) {

			throw new OrderEntriesInvalidException("Please fill all the fields");

		}

	}
}
