package com.akshay.controller;

import java.time.LocalTime;

import org.apache.log4j.Logger;
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

	public void save(@RequestParam("id") Integer id, @RequestParam("catdesc") String catdesc,
			@RequestParam("startTime") LocalTime startTime, @RequestParam("endTime") LocalTime endTime) {

		Logger log = Logger.getLogger(CategoryController.class.getName());
		Category category = new Category();
		category.setId(id);
		category.setCategoryDescription(catdesc);
		category.setStartTime(startTime);
		category.setEndTime(endTime);

		CategoryService categoryService = new CategoryService();
		try {
			categoryService.saveService(category);
		} catch (CategoryServiceException e) {

			log.debug("Service Exception", e);

		}

	}

	@RequestMapping("/update")
	public void update(@RequestParam("id") Integer id, @RequestParam("catdesc") String catdesc) {
		Logger log = Logger.getLogger(CategoryController.class.getName());
		Category category = new Category();
		category.setId(id);
		category.setCategoryDescription(catdesc);

		CategoryService categoryService = new CategoryService();
		try {
			categoryService.updateService(category);
		} catch (CategoryServiceException e) {

			log.debug("Update Controller method exception", e);
		}

	}
}
