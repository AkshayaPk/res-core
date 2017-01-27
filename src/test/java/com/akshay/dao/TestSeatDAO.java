package com.akshay.dao;

import java.util.List;

import com.akshay.dao.SeatDAO;
import com.akshay.model.Seat;

public class TestSeatDAO {

	public static void main(final String[] args) {
		// TODO Auto-generated method stub
		final SeatDAO seatDAO = new SeatDAO();
		final List<Seat> list = seatDAO.list();
		for (final Seat s : list) {
	
		}
	}

}
