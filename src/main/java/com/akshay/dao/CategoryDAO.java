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
		jdbcTemplate.update(sql, params);

	}

	/**
	 * TO DELETE A RECORD FROM THE CATEGORY RELATION
	 * 
	 * @param category
	 */
	public void delete(final Category category) {
		final String sql = "delete from category_master where ID=?";
		final Object[] params = { category.getId() };
		jdbcTemplate.update(sql, params);

	}

	/**
	 * TO UPDATE A RECORD IN THE CATEGORY RELATION
	 * 
	 * @param category
	 */
	public void update(final Category category) {
		final String sql = "update category_master set category_description=? where ID=?";
		final Object[] params = { category.getCategoryDescription(), category.getId() };
		jdbcTemplate.update(sql, params);

	}

	/**
	 * TO LIST ALL THE RECORDS IN THE CATEGORY RELATION
	 * 
	 * @param category
	 */
	public List<Category> list() {
		final String sql = "select ID,CATEGORY_DESCRIPTION,START_TIME,END_TIME from category_master";
		return jdbcTemplate.query(sql, (rs, rowNum) -> {
			return convert(rs);
		});

	}

	/**
	 * Converts Object to ResultSet
	 * 
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
