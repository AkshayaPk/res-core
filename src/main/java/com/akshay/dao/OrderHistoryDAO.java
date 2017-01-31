package com.akshay.dao;

import org.springframework.jdbc.core.JdbcTemplate;


import com.akshay.util.ConnectionUtil;

public class OrderHistoryDAO {

	
    JdbcTemplate jdbcTemplate = ConnectionUtil.getJdbcTemplate();
    public void save()
    {
    	String sql="insert into order_history (SELECT `order_transaction`.`ORDER_NO`,`order_transaction`.`ORDER_DATE`,`order_transaction`.`ORDER_TIME`,`order_item_transaction`.`ITEM_ID`,"
    			+ "order_item_transaction.ORDER_QTY,order_item_transaction.ORDER_ITEM_PRICE from order_transaction join order_item_transaction on order_transaction.ORDER_NO=order_item_transaction.ORDER_NO)";
    	jdbcTemplate.update(sql);
    }
}
