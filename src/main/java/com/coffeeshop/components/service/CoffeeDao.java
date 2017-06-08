package com.coffeeshop.components.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.coffeeshop.components.entity.Coffee;
import com.coffeeshop.components.interface_i.ICoffee;



@Repository
public class CoffeeDao implements ICoffee{
	
	@Autowired
	private JdbcTemplate jdbc;
	
	public static class workingWithRowMap implements RowMapper<Coffee> {
		
		
		public Coffee mapRow(ResultSet rs, int rowNum) throws SQLException {
			Coffee coffee = new Coffee();
			coffee.setId(rs.getInt(1));
			coffee.setName(rs.getString(2));
			coffee.setPrice(rs.getInt(3));
			
			return coffee;
		}
	}
	/*
	 * 
	 * Search
	 * 
	 */
	public Coffee searchByIdCoffee(int id) {
		final String SQL = "Select * FROM  coffee WHERE id=?";
		Coffee coffee = jdbc.queryForObject(SQL, new workingWithRowMap(),id);
		return coffee;
	}
	
	
	/*
	 * 
	 * Search all
	 * 
	 */
	public Collection<Coffee> infoAboutCoffee(int page) {
		page *= 3;
		final String SQL = "SELECT * FROM Coffee LIMIT 3 offset ?";
		List<Coffee> coffee = jdbc.query(SQL, new workingWithRowMap(), page);
		return coffee;
	}
		
	public void addCoffee(Coffee coffee) {
		final String SQL = "INSERT INTO Products (idSubtype, Name, Firm) values (?, ?, ?) ";
		final String name = coffee.getName();
		final int price = coffee.getPrice();
			
		jdbc.update(SQL, new Object[] { name, price });
	}
}
