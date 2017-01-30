package com.akshay.validator;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.akshay.exception.OrderEntriesInvalidException;
import com.akshay.model.Order;

public class OrderValidator {
	private final Logger logger = Logger.getLogger(ItemValidator.class.getName());
	public boolean validateSave(Order order) {
		
		if ("".equals(order.getOrderNo())||"".equals(order.getOrderDate())||"".equals(order.getOrderTime())||"".equals(order.getOrderSeatNo())) {
			try {
				throw new OrderEntriesInvalidException("Please fill all the fields");
			} catch (OrderEntriesInvalidException e) {
				
				logger.log(Level.SEVERE, "Exceptions Happen",e);
			}

		}
		return true;
	}
}
