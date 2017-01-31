package com.akshay.service;

import java.time.LocalTime;

import com.akshay.exception.CategoryNotFoundException;
import com.akshay.exception.CategoryServiceException;
import com.akshay.model.Category;

public class TestCategoryService {

	
	public static void main(String[] args) {
		CategoryService categoryService=new CategoryService();
		Category category = new Category();
		category.setId(6);
		category.setCategoryDescription(null);
		category.setStartTime(LocalTime.parse("09:00:00"));
		category.setEndTime(LocalTime.parse("12:00:00"));
		
		try {
			categoryService.saveService(category);
		} catch (CategoryServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
