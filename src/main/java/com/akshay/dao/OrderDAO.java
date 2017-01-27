package com.akshay.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.akshay.model.Order;
import com.akshay.model.Seat;
import com.akshay.util.ConnectionUtil;

public class OrderDAO {

	private final JdbcTemplate jdbcTemplate = ConnectionUtil.getJdbcTemplate();

	/**
	 * TO INSERT A RECORD INTO THE ORDER RELATION.
	 * 
	 * @param order
	 */
	public void save(final Order order) {
		final String sql = "insert into order_transaction(ORDER_NO,ORDER_DATE,ORDER_TIME,ORDER_SEAT_NO)" + "values (?,?,?,?)";
		final Object[] params = { order.getOrderNo(), order.getOrderDate(), order.getOrderTime(),
				order.getOrderSeatNo().getSeatNo() };
		final int rows = jdbcTemplate.update(sql, params);
		System.out.println(rows);
	}

	/**
	 * TO DELETE A RECORD FROM THE ORDER RELATION.
	 * 
	 * @param order
	 */
	public void delete(final int orderNo) {
		final String sql = "delete from order_transaction where ORDER_NO=?";
		final int rows = jdbcTemplate.update(sql, orderNo);
		System.out.println(rows);
	}

	/**
	 * TO VIEW ALL RECORDS FROM THE ORDER RELATION.
	 * 
	 * @param order
	 */
	public List<Order> list() {
		final String sql = "select ORDER_NO,ORDER_DATE,ORDER_TIME,ORDER_SEAT_NO from order_transaction";
		return jdbcTemplate.query(sql, (rs, rowNum) -> {
			final Order order = convert(rs);
			return order;

		});
	}


	static Order convert(final ResultSet rs) throws SQLException {
		final Order order = new Order();
		order.setOrderNo(rs.getInt("ORDER_NO"));
		order.setOrderDate(rs.getDate("ORDER_DATE").toLocalDate());
		order.setOrderTime(rs.getTime("ORDER_TIME").toLocalTime());
		final Seat seat = new Seat();
		seat.setSeatNo(rs.getInt("ORDER_SEAT_NO"));
		order.setOrderSeatNo(seat);

		return order;
	}

}
