package com.akshay.validator;

import com.akshay.exception.CategoryNotFoundException;
import com.akshay.model.Category;

public class TestCategoryValidator {

	public static void main(final String[] args) {
		
		final Category category = new Category();
	    category.setCategoryDescription("");
		final CategoryValidator categoryValidator=new CategoryValidator();
		try {
			categoryValidator.validateSave(category);
		} catch (CategoryNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
