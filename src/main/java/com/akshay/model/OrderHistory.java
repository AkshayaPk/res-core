package com.akshay.model;

import java.time.LocalDate;
import java.time.LocalTime;

import lombok.Data;

@Data
public class OrderHistory {

	private int orderNo;
	private LocalDate orderDate;
	private LocalTime orderTime;
	private int itemID;
	private int orderQuantity;
	private int orderItemPrice;
}
