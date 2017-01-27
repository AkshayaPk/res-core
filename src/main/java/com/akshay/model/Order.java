package com.akshay.model;

import java.time.LocalDate;
import java.time.LocalTime;

import lombok.Data;

@Data
public class Order {
	private int orderNo;
	private LocalDate orderDate;
	private LocalTime orderTime;
	private Seat orderSeatNo;

}
