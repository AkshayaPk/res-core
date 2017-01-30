package com.akshay.dao;

import java.util.Iterator;
import java.util.List;

import com.akshay.dao.ItemDAO;
import com.akshay.model.Item;

public class TestItemDAO {
	public static void main(final String[] args) {
		final ItemDAO itemDAO = new ItemDAO();
		// Item item=new Item();
		//
		// item.setID(17);
		// item.setItemName("Halwa");
		// Category category = new Category();
		// category.setId(1);
		// item.setCategoryCode(category);
		// item.setItemOpeningStock(100);
		// item.setItemStockOnHand(100);
		// item.setItemClosingStock(100);

		// itemDAO.save(item);

		// itemDAO.delete(17);

		final List<Item> list = itemDAO.listItems();

		final Iterator<Item> ii = list.iterator();
		/*
		 * for(Item i:list) { System.out.println(i); }
		 */

		while (ii.hasNext()) {
			final Item item = (Item) ii.next();
            System.out.println(item.getItemName());
			
		}
//		Boolean isValid = itemDAO.validateItem("ID");
//		System.out.println(isValid);

	}

}
