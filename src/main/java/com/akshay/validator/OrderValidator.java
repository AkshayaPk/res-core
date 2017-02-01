package com.akshay.validator;

import com.akshay.exception.OrderEntriesInvalidException;
import com.akshay.model.Order;

public class OrderValidator {
	public void validateSave(Order order) throws OrderEntriesInvalidException {

		if (order.getOrderNo() <0 || "".equals(order.getOrderDate().toString()) || "".equals(order.getOrderTime().toString())
				|| order.getOrderSeatNo().getSeatNo()<0) {

			throw new OrderEntriesInvalidException("Please fill all the fields");

		}

	}
}
