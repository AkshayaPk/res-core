package com.akshay.validator;




import java.util.logging.Level;
import java.util.logging.Logger;

import com.akshay.exception.CategoryNotFoundException;
import com.akshay.model.Category;

public class CategoryValidator {
	private final Logger logger = Logger.getLogger(CategoryValidator.class.getName());

	public boolean validateSave(Category category)
	{
		
		if("".equals(category.getCategoryDescription())||"".equals(category.getId())||"".equals(category.getStartTime())||"".equals(category.getEndTime()))
		{
			try {
				throw new CategoryNotFoundException("This field cannot be null");
			} catch (CategoryNotFoundException e) {
				
				  logger.log(Level.SEVERE, "Exceptions Happen",e);
			}
		}
		return true;
	}
}
