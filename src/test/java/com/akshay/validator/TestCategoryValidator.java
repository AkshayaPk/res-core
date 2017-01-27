package com.akshay.validator;

import com.akshay.model.Category;

public class TestCategoryValidator {

	public static void main(final String[] args) {
		
		final Category category = new Category();
	    category.setCategoryDescription("");
		final CategoryValidator categoryValidator=new CategoryValidator();
		categoryValidator.validateSave(category);
	}

}
