package com.akshay.dao;

import java.util.Iterator;
import java.util.List;

import com.akshay.dao.OrderDAO;
import com.akshay.model.Order;

public class TestOrderDAO {

	public static void main(final String[] args) {

		final OrderDAO orderDAO = new OrderDAO();
		// Order order = new Order();
		// order.setOrderNo(1);
		// order.setOrderDate(LocalDate.parse("2017-01-25"));
		// order.setOrderTime(LocalTime.now());
		// Seat seat=new Seat();
		// seat.setSeatNo(2);
		// order.setOrderSeatNo(seat);
		//
		// orderDAO.save(order);
		// orderDAO.delete(1);
//		final List<Order> list = orderDAO.list();
//
//		final Iterator<Order> i = list.iterator();
//		while (i.hasNext()) {
//			final Order order = (Order) i.next();
//		
//		}
//          String status=orderDAO.PlaceOrder("Coffee", "2", 9, 7, "errmsg");
//          System.out.println(status);
//          String cancelStatus=orderDAO.CancelOrder(6, "Coffee", "errmsg");
//          System.out.println(cancelStatus);
		 Boolean isPresent=orderDAO.checkNumberOfItemsOrdered("Idly,Dosa,Poori,Pongal,Vada");
		 System.out.println(isPresent);
	}
}
