package com.akshay.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.akshay.model.Seat;
import com.akshay.util.ConnectionUtil;

public class SeatDAO {

	private final JdbcTemplate jdbcTemplate = ConnectionUtil.getJdbcTemplate();

	/**
	 * TO INSERT A RECORD INTO THE SEAT_MASTER RELATION.
	 * 
	 * @param seat
	 */
	public void save(final Seat seat) {
		final String sql = "insert into seat_master(ID,SEAT_NO,SEAT_STATUS) values (?,?,?)";
		final Object[] params = { seat.getId(), seat.getSeatNo(), seat.getSeatStatus() };
		jdbcTemplate.update(sql, params);

	}

	/**
	 * TO UPDATE A RECORD IN THE SEAT_MASTER RELATION.
	 * 
	 * @param seat
	 */
	public void update(final Seat seat) {
		final String sql = "update seat_master set SEAT_STATUS=? where SEAT_NO= ?";
		final Object[] params = { seat.getSeatStatus(), seat.getSeatNo() };
		jdbcTemplate.update(sql, params);

	}

	/**
	 * TO DELETE A RECORD FROM THE SEAT_MASTER RELATION.
	 * 
	 * @param seat
	 */
	public void delete(final Seat seat) {
		final String sql = "delete from seat_master where id=?";
		Object[] params = { seat.getId() };
		jdbcTemplate.update(sql, params);

	}

	/**
	 * TO VIEW ALL THE SEATS FROM THE SEAT_MASTER RELATION.
	 * 
	 * @param seat
	 */
	public List<Seat> list() {
		final String sql = "Select ID,SEAT_NO,SEAT_STATUS from seat_master";
		return jdbcTemplate.query(sql, (rs, rowNum) -> 
			 convert(rs)
		);

	}

	public Seat convert(final ResultSet rs) throws SQLException {
		final Seat seat = new Seat();
		seat.setId(rs.getInt("ID"));
		seat.setSeatNo(rs.getInt("SEAT_NO"));
		seat.setSeatStatus(rs.getString("SEAT_STATUS"));
		return seat;
	}

}
