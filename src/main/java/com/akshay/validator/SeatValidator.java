package com.akshay.validator;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.akshay.exception.SeatInvalidEntriesException;
import com.akshay.model.Seat;

public class SeatValidator {
	private final Logger logger = Logger.getLogger(CategoryValidator.class.getName());

	public boolean validateSave(Seat seat) {
		if ("".equals(seat.getId()) || "".equals(seat.getSeatNo()) || "".equals(seat.getSeatStatus())) {
			try {
				throw new SeatInvalidEntriesException("This field cannot be null");
			} catch (SeatInvalidEntriesException e) {

				logger.log(Level.SEVERE, "Exceptions Happen", e);
			}
		}
		return true;
	}
}
