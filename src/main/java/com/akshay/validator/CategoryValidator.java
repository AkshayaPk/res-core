package com.akshay.validator;

import com.akshay.exception.CategoryNotFoundException;
import com.akshay.model.Category;

public class CategoryValidator {

	
	public void validateSave(Category category)
	{
		if("".equals(category.getCategoryDescription()))
		{
			try {
				throw new CategoryNotFoundException("This field cannot be null");
			} catch (CategoryNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
