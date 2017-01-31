package com.akshay.service;


import com.akshay.dao.SeatDAO;
import com.akshay.exception.SeatInvalidEntriesException;
import com.akshay.exception.SeatServiceException;
import com.akshay.model.Seat;

import com.akshay.validator.SeatValidator;

public class SeatService {

	
	public void provideService(Seat seat) throws SeatServiceException
	{
		SeatValidator seatValidator=new SeatValidator();
		SeatDAO seatDAO=new SeatDAO();
		try
		{
			seatValidator.validateSave(seat);
			seatDAO.save(seat);
		}
		catch(SeatInvalidEntriesException e)
		{
			throw new SeatServiceException("SeatService exception caught");
		}
	}
}
