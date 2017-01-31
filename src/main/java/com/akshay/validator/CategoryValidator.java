package com.akshay.validator;



import com.akshay.exception.CategoryNotFoundException;
import com.akshay.model.Category;

public class CategoryValidator {

	public void validateSave(Category category) throws CategoryNotFoundException {

		if ("".equals(category.getCategoryDescription()) || "".equals(category.getId())
				|| "".equals(category.getStartTime()) || "".equals(category.getEndTime())) {

			throw new CategoryNotFoundException("This field cannot be null");

		}

	}
}
