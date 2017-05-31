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
public class CoffeeShopDao implements ICoffee{
	
	@Autowired
	private JdbcTemplate jdbc;
	
	public static class workingWithRowMap implements RowMapper<Coffee> {
		
		
		public Coffee mapRow(ResultSet rs, int rowNum) throws SQLException {
			Coffee coffee = new Coffee();
			Coffee.setId(rs.getInt(1));
			Coffee.setName(rs.getString(2));
			Coffee.setPrice(rs.getInt(3));
			
			return coffee;
		}
	}
	/*
	 * 
	 * Search
	 * 
	 */
	public Coffee searchById(int id) {
		final String SQL = "Select * FROM  coffee WHERE id=?";
		Coffee coffee = jdbc.queryForObject(SQL, new workingWithRowMap(),id);
		return coffee;
	}
	/*
	 * 
	 * Update
	 * 
	 */
	public void updateCoffee(Coffee coffee){
		final String SQL = "UPDATE bike SET name=?,price=? WHERE id=?";
		final int id = coffee.getId();
		final String name = coffee.getName();
		final int price = coffee.getPrice();
		
		jdbc.update(SQL, new Object[]{name,price,id});
		
	}
	/*
	 * 
	 * 
	 * 
	 */

}
