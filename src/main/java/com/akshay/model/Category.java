package com.akshay.model;

import java.time.LocalTime;

import lombok.Data;
/**
 * Model Class
 * @author Akshay
 *
 */
@Data
public class Category {
	private int id;
	private String categoryDescription;
	private LocalTime startTime;
	private LocalTime endTime;

}
