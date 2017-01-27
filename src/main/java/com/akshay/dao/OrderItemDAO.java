package com.akshay.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.akshay.model.Item;
import com.akshay.model.Order;
import com.akshay.model.OrderItem;
import com.akshay.util.ConnectionUtil;

public class OrderItemDAO {

	private final JdbcTemplate jdbcTemplate = ConnectionUtil.getJdbcTemplate();

	/**
	 * TO INSERT A RECORD INTO THE ORDER_ITEM_TRANSACTION
	 * 
	 * @param orderItem
	 */
	public void save(final OrderItem orderItem) {
		final String sql = "insert into order_item_transaction(ID,ORDER_NO,ITEM_ID,ORDER_QTY,ORDER_ITEM_PRICE,PAYMENT_STATUS)"
				+ "values (?,?,?,?,?,?) ";
		final Object[] params = { orderItem.getId(), orderItem.getOrderNo().getOrderNo(), orderItem.getItemID().getID(),
				orderItem.getOrderQty(), orderItem.getOrderItemPrice(), orderItem.getPaymentStatus() };
		jdbcTemplate.update(sql, params);
		
	}

	/**
	 * TO DELETE A RECORD FROM THE ORDER_ITEM_TRANSACTION
	 * 
	 * @param orderItem
	 */
	public void delete(final int id) {
		final String sql = "delete from order_item_transaction where id=?";
		 jdbcTemplate.update(sql, id);
		
	}

	/**
	 * TO VIEW ALL ITEM TRANSACTIONS FROM THE ORDER_ITEM_TRANSACTION
	 * 
	 * @param orderItem
	 */
	public List<OrderItem> list() {
		final String sql = "Select ID,ORDER_NO,ITEM_ID,ORDER_QTY,ORDER_ITEM_PRICE,PAYMENT_STATUS from order_item_transaction";
		return jdbcTemplate.query(sql, (rs, rowNum) -> {
			final OrderItem item = convert(rs);
			return item;
		});
	}
 /**
  * CONVERT OBJECT TO RESULTSET
  * @param rs
  * @return
  * @throws SQLException
  */
	public OrderItem convert(final ResultSet rs) throws SQLException {
		final OrderItem orderItem = new OrderItem();
		orderItem.setId(rs.getInt("ID"));
		final Order order = new Order();
		order.setOrderNo(rs.getInt("ORDER_NO"));
		final Item item = new Item();
		item.setID(rs.getInt("ITEM_ID"));
		orderItem.setOrderNo(order);
		orderItem.setItemID(item);
		orderItem.setOrderQty(rs.getInt("ORDER_QTY"));
		orderItem.setOrderItemPrice(rs.getInt("ORDER_ITEM_PRICE"));
		orderItem.setPaymentStatus(rs.getString("PAYMENT_STATUS"));

		return orderItem;
	}

}
