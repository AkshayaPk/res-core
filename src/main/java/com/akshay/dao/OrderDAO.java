package com.akshay.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;

import com.akshay.model.Order;
import com.akshay.model.Seat;
import com.akshay.util.ConnectionUtil;

public class OrderDAO {

	private static final String ERRMSG2 = "errmsg";
	private static final String I_ORDERID = "i_orderid";
	private final JdbcTemplate jdbcTemplate = ConnectionUtil.getJdbcTemplate();

	/**
	 * TO INSERT A RECORD INTO THE ORDER RELATION.
	 * 
	 * @param order
	 */
	public void save(final Order order) {
		final String sql = "insert into order_transaction(ORDER_NO,ORDER_DATE,ORDER_TIME,ORDER_SEAT_NO)"
				+ "values (?,?,?,?)";
		final Object[] params = { order.getOrderNo(), order.getOrderDate(), order.getOrderTime(),
				order.getOrderSeatNo().getSeatNo() };
		jdbcTemplate.update(sql, params);

	}

	/**
	 * TO DELETE A RECORD FROM THE ORDER RELATION.
	 * 
	 * @param order
	 */
	public void delete(final int orderNo) {
		final String sql = "delete from order_transaction where ORDER_NO=?";
		jdbcTemplate.update(sql, orderNo);

	}

	/**
	 * TO VIEW ALL RECORDS FROM THE ORDER RELATION.
	 * 
	 * @param order
	 */
	public List<Order> list() {
		final String sql = "select ORDER_NO,ORDER_DATE,ORDER_TIME,ORDER_SEAT_NO from order_transaction";
		return jdbcTemplate.query(sql, (rs, rowNum) -> 
			 convert(rs)

		);
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

	public String placeOrder(String foodname, String quantity, int orderid, int seatno, String errmsg) {
		SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplate).withProcedureName("PR_ORDERFOOD").declareParameters(
				new SqlParameter("_food", Types.VARCHAR), new SqlParameter("_quan", Types.VARCHAR),
				new SqlParameter(I_ORDERID, Types.INTEGER), new SqlParameter("i_seatno", Types.INTEGER),
				new SqlOutParameter(ERRMSG2, Types.VARCHAR));
		call.setAccessCallParameterMetaData(false);
		SqlParameterSource in = new MapSqlParameterSource().addValue("_food", foodname).addValue("_quan", quantity)
				.addValue(I_ORDERID, orderid).addValue("i_seatno", seatno).addValue(ERRMSG2, errmsg);
		Map<String, Object> execute = call.execute(in);
		return (String) execute.get(ERRMSG2);

	}

	public String cancelOrder(int orderid, String foodname, String errmsg) {
		SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplate).withProcedureName("PR_CANCEL_ORDER").declareParameters(
				new SqlParameter(I_ORDERID, Types.INTEGER), new SqlParameter("i_foodname", Types.VARCHAR),
				new SqlOutParameter(ERRMSG2, Types.VARCHAR));
		call.setAccessCallParameterMetaData(false);
		SqlParameterSource in = new MapSqlParameterSource().addValue(I_ORDERID, orderid)
				.addValue("i_foodname", foodname).addValue(ERRMSG2, errmsg);
		return (String) call.execute(in).get(ERRMSG2);

	}

	public Boolean validateOrderNo(int orderNo) {
		String sql = "select FN_CHECK_ORDERNO(?)";
		return jdbcTemplate.queryForObject(sql, new Object[] { orderNo }, Boolean.class);
	}

	public Boolean checkItemCategoryServed(String foodname) {
		String sql = "select FN_IS_ITEM_CATEGORY_SERVED(?)";
		return jdbcTemplate.queryForObject(sql, new Object[] { foodname }, Boolean.class);
	}

	public Boolean checkNumberOfItemsOrdered(String foodname) {
		String sql = "select FN_CHECK_NUMBER_ITEMS(?)";
		return jdbcTemplate.queryForObject(sql, new Object[] { foodname }, Boolean.class);
	}
}
