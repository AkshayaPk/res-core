package com.akshay.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.akshay.exception.SeatServiceException;
import com.akshay.model.Seat;
import com.akshay.service.SeatService;

@Controller
@RequestMapping("/Seat")
public class SeatController {
	@RequestMapping("save")
	public void save(@RequestParam("id") Integer id, @RequestParam("seatNo") Integer seatNo,
			@RequestParam("seatStatus") String seatStatus) {
		Logger log = Logger.getLogger(CategoryController.class.getName());
		Seat seat = new Seat();
		seat.setId(id);
		seat.setSeatNo(seatNo);
		seat.setSeatStatus(seatStatus);

		SeatService seatService = new SeatService();
		try {
			seatService.provideService(seat);
		} catch (SeatServiceException e) {

			log.debug("SeatService Exception", e);
		}
	}

	public void update(@RequestParam("seatNo") Integer seatNo, @RequestParam("seatStatus") String seatStatus) {
		Logger log = Logger.getLogger(CategoryController.class.getName());
		Seat seat = new Seat();

		seat.setSeatNo(seatNo);
		seat.setSeatStatus(seatStatus);

		SeatService seatService = new SeatService();
		try {
			seatService.updateService(seat);
		} catch (SeatServiceException e) {

			log.debug("SeatService Exception", e);
		}
	}
}
