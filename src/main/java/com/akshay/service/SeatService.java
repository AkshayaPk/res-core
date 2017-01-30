package com.akshay.service;


import com.akshay.dao.SeatDAO;

import com.akshay.model.Seat;

import com.akshay.validator.SeatValidator;

public class SeatService {

	
	public void provideService(Seat seat)
	{
		SeatValidator seatValidator=new SeatValidator();
		SeatDAO seatDAO=new SeatDAO();
		if(seatValidator.validateSave(seat)==true)
		{
			seatDAO.save(seat);
		}
	}
}
