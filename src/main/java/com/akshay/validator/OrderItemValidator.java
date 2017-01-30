package com.akshay.validator;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.akshay.exception.OrderItemInvalidEntriesException;
import com.akshay.model.OrderItem;

public class OrderItemValidator {

	
	private final Logger logger = Logger.getLogger(ItemValidator.class.getName());
	public boolean validateSave(OrderItem orderItem) {
		
		if ("".equals(orderItem.getId())||"".equals(orderItem.getItemID())||"".equals(orderItem.getOrderItemPrice())||"".equals(orderItem.getOrderNo())||"".equals(orderItem.getOrderQty())||"".equals(orderItem.getPaymentStatus())) {
			try {
				throw new OrderItemInvalidEntriesException("Please fill all fields.");
			} catch (OrderItemInvalidEntriesException e) {
				
				logger.log(Level.SEVERE, "Exceptions Happen",e);
			}

		}
		return true;
	}
}
