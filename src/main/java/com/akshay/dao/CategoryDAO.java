package com.akshay.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.akshay.model.Category;
import com.akshay.util.ConnectionUtil;

public class CategoryDAO {
	private final JdbcTemplate jdbcTemplate = ConnectionUtil.getJdbcTemplate();

	/**
	 * TO INSERT A RECORD INTO THE CATEGORY RELATION
	 * 
	 * @param category
	 */
	public void save(final Category category) {
		final String sql = "insert into category_master (ID,CATEGORY_DESCRIPTION,START_TIME,END_TIME) values (?,?,?,?) ";
		final Object[] params = { category.getId(), category.getCategoryDescription(), category.getStartTime(),
				category.getEndTime() };
		final int rows = jdbcTemplate.update(sql, params);
		System.out.println(rows);
	}

	/**
	 * TO DELETE A RECORD FROM THE CATEGORY RELATION
	 * 
	 * @param category
	 */
	public void delete(final int id) {
		final String sql = "delete from category_master where ID=?";
		final Object[] params = { id };
		final int rows = jdbcTemplate.update(sql, params);
		System.out.println(rows);
	}

	/**
	 * TO UPDATE A RECORD IN THE CATEGORY RELATION
	 * 
	 * @param category
	 */
	public void update(final Category category) {
		final String sql = "update category_master set category_description=? where ID=?";
		final Object[] params = { category.getCategoryDescription(), category.getId() };
		final int rows = jdbcTemplate.update(sql, params);
		System.out.println(rows);
	}

	/**
	 * TO LIST ALL THE RECORDS IN THE CATEGORY RELATION
	 * 
	 * @param category
	 */
	public List<Category> list() {
		final String sql = "select ID,CATEGORY_DESCRIPTION,START_TIME,END_TIME from category_master";
		return jdbcTemplate.query(sql, (rs, rowNum) -> {
			final Category category = convert(rs);
			return category;
		});

	}
 /**
  * Converts Object to ResultSet
  * @param rs
  * @return
  * @throws SQLException
  */
	static Category convert(final ResultSet rs) throws SQLException {
		final Category category = new Category();
		category.setId(rs.getInt("ID"));
		category.setCategoryDescription(rs.getString("CATEGORY_DESCRIPTION"));
		category.setStartTime(rs.getTime("START_TIME").toLocalTime());
		category.setEndTime(rs.getTime("END_TIME").toLocalTime());
		return category;
	}
}
