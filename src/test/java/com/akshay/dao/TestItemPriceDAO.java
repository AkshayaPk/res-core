package com.akshay.dao;

import java.util.List;

import com.akshay.dao.ItemPriceDAO;
import com.akshay.model.ItemPrice;

public class TestItemPriceDAO {

	public static void main(final String[] args) {

		final ItemPriceDAO itemPriceDAO = new ItemPriceDAO();

		final List<ItemPrice> list = itemPriceDAO.list();
		for (final ItemPrice i : list) {
			
		}

	}

}
