package com.akshay.model;

import lombok.Data;

@Data
public class OrderItem {
	private int id;
	private Order orderNo;
	private Item itemID;
	private int orderQty;
	private int orderItemPrice;
	private String paymentStatus;
}
