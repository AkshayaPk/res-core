package com.akshay.dao;

import java.util.Iterator;
import java.util.List;

import com.akshay.dao.OrderItemDAO;
import com.akshay.model.OrderItem;

public class TestOrderItemDAO {
	public static void main(final String[] args) {
		final OrderItemDAO orderItemDAO = new OrderItemDAO();

		final List<OrderItem> list = orderItemDAO.list();

		final Iterator<OrderItem> i = list.iterator();
		while (i.hasNext()) {
			final OrderItem orderItem = i.next();
			System.out.println(orderItem.getId());
			System.out.println(orderItem.getOrderNo().getOrderNo());
			System.out.println(orderItem.getItemID().getID());
			System.out.println(orderItem.getOrderQty());
			System.out.println(orderItem.getOrderItemPrice());
			System.out.println(orderItem.getPaymentStatus());
		}

	}
}
