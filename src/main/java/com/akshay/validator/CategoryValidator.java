package com.akshay.validator;




import java.util.logging.Level;
import java.util.logging.Logger;

import com.akshay.exception.CategoryNotFoundException;
import com.akshay.model.Category;

public class CategoryValidator {

private static Logger logger = Logger.getLogger(CategoryValidator.class.getName());
	public void validateSave(Category category)
	{
		if("".equals(category.getCategoryDescription()))
		{
			try {
				throw new CategoryNotFoundException("This field cannot be null");
			} catch (CategoryNotFoundException e) {
				
				  logger.log(Level.SEVERE, "Exceptions Happen",e);
			}
		}
	}
}
