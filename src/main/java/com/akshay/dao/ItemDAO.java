package com.akshay.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.akshay.model.Category;
import com.akshay.model.Item;
import com.akshay.util.ConnectionUtil;

public class ItemDAO {

	private final JdbcTemplate jdbcTemplate = ConnectionUtil.getJdbcTemplate();

	/**
	 * TO INSERT A RECORD INTO THE ITEM_MASTER RELATION.
	 * 
	 * @param item
	 */
	public void save(final Item item) {
		final String sql = "insert into item_master(ID,ITEM_NAME,ITEM_CATEGORY_CODE,ITEM_OPENING_STOCK,ITEM_STOCK_ON_HAND,ITEM_CLOSING_STOCK)"
				+ "values (?,?,?,?,?,?) ";
		final Object[] params = { item.getId(), item.getItemName(), item.getCategoryCode().getId(),
				item.getItemOpeningStock(), item.getItemStockOnHand(), item.getItemClosingStock() };
		jdbcTemplate.update(sql, params);

	}

	/**
	 * TO DELETE A RECORD FROM THE ITEM_MASTER RELATION.
	 * 
	 * @param item
	 */
	public void delete(final Item item) {
		final String sql = "delete from item_master where id=?";
		Object[] params = { item.getId() };
		jdbcTemplate.update(sql, params);

	}

	/**
	 * TO UPDATE A RECORD IN THE ITEM_MASTER RELATION.
	 * 
	 * @param item
	 */
	public void update(final Item item) {
		final String sql = "update item_master set ITEM_NAME=? where ID=?";
		final Object[] params = { item.getItemName(), item.getId() };
		jdbcTemplate.update(sql, params);

	}

	/**
	 * TO VIEW ALL ITEMS IN THE ITEM_MASTER RELATION.
	 * 
	 * @param item
	 */
	public List<Item> list() {
		final String sql = "Select ID,ITEM_NAME,ITEM_CATEGORY_CODE,ITEM_OPENING_STOCK,ITEM_STOCK_ON_HAND,ITEM_CLOSING_STOCK from item_master";
		return jdbcTemplate.query(sql, (rs, rowNum) -> 
			 convert(rs)
		);
	}

	public Item convert(final ResultSet rs) throws SQLException {
		final Item item = new Item();

		item.setId(rs.getInt("ID"));
		item.setItemName(rs.getString("ITEM_NAME"));
		final Category category = new Category();
		category.setId(rs.getInt("ITEM_CATEGORY_CODE"));
		item.setCategoryCode(category);
		item.setItemOpeningStock(rs.getInt("ITEM_OPENING_STOCK"));
		item.setItemStockOnHand(rs.getInt("ITEM_STOCK_ON_HAND"));
		item.setItemClosingStock(rs.getInt("ITEM_CLOSING_STOCK"));
		return item;
	}

	public Boolean validateItem(String name) {
		String sql = "select FN_CHECK_ITEM_IN_LIST(?)";
		return jdbcTemplate.queryForObject(sql, new Object[] { name }, Boolean.class);
	}

	public List<Item> listItems() {
		String sql = "select distinct ITEM_NAME from ITEM_MASTER";
		return jdbcTemplate.query(sql, (rs, rowNum) -> 
			 convertForMenu(rs)
		);
	}

	public Item convertForMenu(final ResultSet rs) throws SQLException {
		final Item item = new Item();
		item.setItemName(rs.getString("ITEM_NAME"));
		return item;
	}

}
