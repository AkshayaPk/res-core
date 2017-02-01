package com.akshay.model;

import lombok.Data;

@Data
public class Item {

	private int id;
	private String itemName;
	private Category categoryCode;
	private int itemOpeningStock;
	private int itemStockOnHand;
	private int itemClosingStock;
}
