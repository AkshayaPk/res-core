package com.akshay.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.akshay.model.ItemPrice;
import com.akshay.util.ConnectionUtil;

public class ItemPriceDAO {

	private final JdbcTemplate jdbcTemplate = ConnectionUtil.getJdbcTemplate();

	/**
	 * TO INSERT A RECORD INTO THE ITEM_PRICE RELATION.
	 * 
	 * @param itemPrice
	 */
	public void save(final ItemPrice itemPrice) {
		final String sql = "insert into item_price(ID,ITEM_NAME,PRICE) values (?,?,?)";
		final Object[] params = { itemPrice.getID(), itemPrice.getItemName(), itemPrice.getPrice() };
		final int rows = jdbcTemplate.update(sql, params);
		
	}

	/**
	 * TO UPDATE A RECORD IN THE ITEM_PRICE RELATION.
	 * 
	 * @param itemPrice
	 */
	public void update(final ItemPrice itemPrice) {
		final String sql = "update item_price set ITEM_NAME=? where ID=? ";
		final Object[] params = { itemPrice.getItemName(), itemPrice.getID() };
		final int rows = jdbcTemplate.update(sql, params);
		
	}

	/**
	 * TO DELETE A RECORD FROM THE ITEM_PRICE RELATION.
	 * 
	 * @param itemPrice
	 */
	public void delete(final int id) {
		final String sql = "delete from item_price where ID=?";

		final int rows = jdbcTemplate.update(sql, id);
		

	}

	/**
	 * TO VIEW ALL THE ITEMS WITH THEIR FROM FROM THE ITEM_PRICE RELATION.
	 * 
	 * @param itemPrice
	 */
	public List<ItemPrice> list() {
		final String sql = "select ID,ITEM_NAME,PRICE from item_price";
		return jdbcTemplate.query(sql, (rs, rowNum) -> {
			final ItemPrice itemPrice = convert(rs);
			return itemPrice;

		});
	}
/**
 * Object to ResultSet
 * @param rs
 * @return
 * @throws SQLException
 */
	static ItemPrice convert(final ResultSet rs) throws SQLException {
		final ItemPrice itemPrice = new ItemPrice();
		itemPrice.setID(rs.getInt("ID"));
		itemPrice.setItemName(rs.getString("ITEM_NAME"));
		itemPrice.setPrice(rs.getInt("PRICE"));

		return itemPrice;
	}

}
