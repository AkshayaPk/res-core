package com.akshay.validator;

import com.akshay.exception.OrderItemInvalidEntriesException;
import com.akshay.model.OrderItem;

public class OrderItemValidator {

	public void validateSave(OrderItem orderItem) throws OrderItemInvalidEntriesException {

		if (("".equals(orderItem.getId()) || "".equals(orderItem.getItemID()) || "".equals(orderItem.getOrderItemPrice())
				|| "".equals(orderItem.getOrderNo()) || "".equals(orderItem.getOrderQty())
				|| "".equals(orderItem.getPaymentStatus()))) {

			throw new OrderItemInvalidEntriesException("Please fill all fields.");

		}

	}
}
