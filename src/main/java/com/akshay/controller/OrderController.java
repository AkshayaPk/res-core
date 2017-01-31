package com.akshay.controller;

import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.akshay.exception.OrderServiceException;
import com.akshay.model.Order;
import com.akshay.model.Seat;
import com.akshay.service.OrderService;

@Controller
@RequestMapping("/Order")
public class OrderController {
@RequestMapping("/save")
	public void save(@RequestParam("orderno") Integer orderNo,@RequestParam("orderDate") LocalDate orderDate,@RequestParam("orderTime") LocalTime orderTime,@RequestParam()Integer orderSeatNo)
	{
		Order order=new Order();
		order.setOrderNo(orderNo);
		order.setOrderDate(orderDate);
		order.setOrderTime(orderTime);
		Seat seat = new Seat();
		seat.setSeatNo(orderSeatNo);
		order.setOrderSeatNo(seat);
		
		OrderService orderService = new OrderService();
		try {
			orderService.provideService(order);
		} catch (OrderServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
