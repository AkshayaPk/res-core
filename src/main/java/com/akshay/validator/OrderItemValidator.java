package com.akshay.validator;

import com.akshay.exception.OrderItemInvalidEntriesException;
import com.akshay.model.OrderItem;

public class OrderItemValidator {

	public void validateSave(OrderItem orderItem) throws OrderItemInvalidEntriesException {

		if (orderItem.getId()<0 || orderItem.getOrderQty() < 0 || orderItem.getOrderItemPrice()<0 || "".equals(orderItem.getPaymentStatus())) {

			throw new OrderItemInvalidEntriesException("Please fill all fields.");

		}

	}
}
