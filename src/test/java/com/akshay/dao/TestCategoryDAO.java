package com.akshay.dao;

import java.util.List;

import com.akshay.dao.CategoryDAO;
import com.akshay.model.Category;

public class TestCategoryDAO {

	public static void main(final String[] args) {
		// TODO Auto-generated method stub

		final CategoryDAO categoryDAO = new CategoryDAO();
		// CategoryModel categorymodel=new CategoryModel();
		// categorymodel.setId(4);
		// categorymodel.setCategoryDescription("DINNER");
		//
		// categorymodel.setStartTime(LocalTime.parse("09:00:00"));
		// categorymodel.setEndTime(LocalTime.parse("12:00:00"));
		// categoryDAO.save(categorymodel);
		// categoryDAO.delete(5);
		// categoryDAO.update(categorymodel);

		final List<Category> list = categoryDAO.list();
		for (final Category c : list) {
			
		}
	}

}
