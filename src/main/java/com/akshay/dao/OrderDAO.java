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
	
	public String PlaceOrder(String foodname,String quantity,int orderid,int seatno,String errmsg) {
        SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplate).withProcedureName("PR_ORDERFOOD")
                .declareParameters(new SqlParameter("_food", Types.VARCHAR),new SqlParameter("_quan", Types.VARCHAR),
                		new SqlParameter("i_orderid", Types.INTEGER),new SqlParameter("i_seatno", Types.INTEGER),new SqlOutParameter("errmsg", Types.VARCHAR));
        call.setAccessCallParameterMetaData(false);
        SqlParameterSource in = new MapSqlParameterSource().addValue("_food", foodname).addValue("_quan", quantity).addValue("i_orderid", orderid).addValue("i_seatno",seatno).addValue("errmsg", errmsg);
        Map<String, Object> execute = call.execute(in);
        String status = (String) execute.get("errmsg");
        return status;

}
	public String CancelOrder(int orderid,String foodname,String errmsg) {
        SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplate).withProcedureName("PR_CANCEL_ORDER")
                .declareParameters(new SqlParameter("i_orderid", Types.INTEGER),new SqlParameter("i_foodname", Types.VARCHAR),
                	new SqlOutParameter("errmsg", Types.VARCHAR));
        call.setAccessCallParameterMetaData(false);
        SqlParameterSource in = new MapSqlParameterSource().addValue("i_orderid", orderid).addValue("i_foodname", foodname).addValue("errmsg", errmsg);
        Map<String, Object> execute = call.execute(in);
        String status = (String) execute.get("errmsg");
        return status;

}
	public Boolean validateOrderNo(int orderNo) {
		String sql = "select FN_CHECK_ORDERNO(?)";
		Boolean isAvailable= jdbcTemplate.queryForObject(sql, new Object[] { orderNo },    Boolean.class);
		return isAvailable;
		}
	public Boolean CheckItemCategoryServed(String foodname) {
		String sql = "select FN_IS_ITEM_CATEGORY_SERVED(?)";
		Boolean isAvailable= jdbcTemplate.queryForObject(sql, new Object[] { foodname },    Boolean.class);
		return isAvailable;
		}
}
