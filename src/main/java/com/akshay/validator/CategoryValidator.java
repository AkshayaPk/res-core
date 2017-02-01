package com.akshay.validator;

import com.akshay.exception.CategoryNotFoundException;
import com.akshay.model.Category;

public class CategoryValidator {

	public void validateSave(Category category) throws CategoryNotFoundException {

		if (("".equals(category.getCategoryDescription())
				|| "".equals(category.getStartTime()) || "".equals(category.getEndTime()) || category.getId() < 0
				|| category.getCategoryDescription() == null || category.getStartTime() == null
				|| category.getEndTime() == null)) {

			throw new CategoryNotFoundException("This field cannot be null");

		}

	}
	public void validateUpdate(Category category) throws CategoryNotFoundException
	{
		if(category.getCategoryDescription()==null || "".equals(category.getCategoryDescription())|| category.getId()<0)
		{
			throw new CategoryNotFoundException("Please enter these required fields");
		}
	}
	public void validateDelete(Category category) throws CategoryNotFoundException
	{
		if(category.getId()<0)
		{
			throw new CategoryNotFoundException("Please enter ID");
		}
	}
}
