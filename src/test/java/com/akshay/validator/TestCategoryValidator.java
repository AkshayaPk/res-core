package com.akshay.validator;

import com.akshay.model.Category;
import com.akshay.model.Item;

public class TestCategoryValidator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Category category = new Category();
	    category.setCategoryDescription("");
		CategoryValidator categoryValidator=new CategoryValidator();
		categoryValidator.validateSave(category);
	}

}
