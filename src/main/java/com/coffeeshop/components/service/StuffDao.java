package com.coffeeshop.components.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.coffeeshop.components.entity.Stuff;
import com.coffeeshop.components.interface_i.IStuff;

@Repository
public class StuffDao implements IStuff{
	/**
	 * variable to work with the base
	 */
	@Autowired
	private JdbcTemplate jdbc;

	public static class workingWithRowMap implements RowMapper<Stuff> {
		/**
		 * copy data from DB to customer
		 */
		public Stuff mapRow(ResultSet rs, int rowNum) throws SQLException {
			Stuff stuff = new Stuff();
			stuff.setId(rs.getInt(1));
			stuff.setSurName(rs.getString(3));
			stuff.setName(rs.getString(2));	
			stuff.setMiddleName(rs.getString(4));
			stuff.setDateBirth(rs.getString(5));

			return stuff;
		}
	}

	/**
	 * Looking information about worker by id
	 * 
	 * @param id
	 * @return worker
	 */
	public Stuff searchByIdStuff(int id) {
		final String SQL = "SELECT * FROM Stuff WHERE id=?";
		Stuff stuff = jdbc.queryForObject(SQL, new workingWithRowMap(), id);
		return stuff;
	}
	
	/**
	 * Select all information about workers
	 * @param page
	 * @return workers
	 */
	public Collection<Stuff> infoAboutStuff(int page) {
		page *= 3;
		final String SQL = "SELECT * FROM Stuff LIMIT 3 offset ?";
		List<Stuff> stuff = jdbc.query(SQL, new workingWithRowMap(), page);
		return stuff;
	}

	public void addStuff(Stuff stuff) {
		final String SQL = "INSERT INTO Stuff (Surname, Name, MiddleName, DateOfBirth) values (?, ?, ?, ?) ";
		final String surName = stuff.getSurName();
		final String name = stuff.getName();	
		final String middleName = stuff.getMiddleName();
		final String dateBirth = stuff.getDateBirth();

		jdbc.update(SQL, new Object[] { surName, name, middleName, dateBirth });
	}

}
