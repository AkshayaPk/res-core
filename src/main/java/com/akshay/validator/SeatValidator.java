package com.akshay.validator;

import com.akshay.exception.SeatInvalidEntriesException;
import com.akshay.model.Seat;

public class SeatValidator {

	public boolean validateSave(Seat seat) throws SeatInvalidEntriesException {
		if ("".equals(seat.getId()) || "".equals(seat.getSeatNo()) || "".equals(seat.getSeatStatus())) {
			
				throw new SeatInvalidEntriesException("This field cannot be null");
			
		}
		return true;
	}
}
