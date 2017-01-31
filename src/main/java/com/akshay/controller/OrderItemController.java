package com.akshay.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.akshay.exception.OrderItemServiceException;
import com.akshay.model.Item;
import com.akshay.model.Order;
import com.akshay.model.OrderItem;
import com.akshay.service.OrderItemService;

@Controller
@RequestMapping("/OrderItem")
public class OrderItemController {
	@RequestMapping("/save")
	public void save(@RequestParam("id") Integer id, @RequestParam("orderNo") Integer orderNo,
			@RequestParam("itemId") Integer itemId, @RequestParam("qty") Integer qty,
			@RequestParam("orderItemPrice") Integer orderItemPrice,
			@RequestParam("paymentStatus") String paymentStatus) {
		Logger log = Logger.getLogger(CategoryController.class.getName());

		OrderItem orderItem = new OrderItem();
		Order order = new Order();
		Item item = new Item();

		orderItem.setId(id);
		order.setOrderNo(orderNo);
		orderItem.setOrderNo(order);

		item.setId(itemId);
		orderItem.setItemID(item);

		orderItem.setOrderQty(qty);
		orderItem.setOrderItemPrice(orderItemPrice);
		orderItem.setPaymentStatus(paymentStatus);

		OrderItemService orderItemService = new OrderItemService();
		try {
			orderItemService.provideService(orderItem);
		} catch (OrderItemServiceException e) {
			log.debug("ItemServiceException", e);
		}

	}
}
