package com.akshay.controller;

import java.time.LocalTime;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.akshay.exception.CategoryServiceException;
import com.akshay.model.Category;
import com.akshay.service.CategoryService;

@Controller
@RequestMapping("/Category")
public class CategoryController {
@RequestMapping("/save")
	public void save(@RequestParam("id") Integer id,@RequestParam("catdesc") String catdesc,@RequestParam("startTime") LocalTime startTime,@RequestParam("endTime") LocalTime endTime)
	{
		System.out.println("Save method called from controller");
		Category category = new Category();
		category.setId(id);
		category.setCategoryDescription(catdesc);
		category.setStartTime(startTime);
		category.setEndTime(endTime);
		System.out.println(category);
		
		CategoryService categoryService=new CategoryService();
		try {
			categoryService.saveService(category);
		} catch (CategoryServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	}
@RequestMapping("/update")
public void update(@RequestParam("id") Integer id,@RequestParam("catdesc") String catdesc)
{
	System.out.println("update method called from controller");
	Category category = new Category();
	category.setId(id);
	category.setCategoryDescription(catdesc);

	System.out.println(category);
	
	CategoryService categoryService=new CategoryService();
	try {
		categoryService.updateService(category);
	} catch (CategoryServiceException e) {
		
		e.printStackTrace();
	}
    
}
}
