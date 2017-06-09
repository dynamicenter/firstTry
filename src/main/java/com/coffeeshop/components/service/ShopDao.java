package com.coffeeshop.components.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.coffeeshop.components.entity.Shop;
import com.coffeeshop.components.interface_i.IShop;

@Repository
public class ShopDao implements IShop{
	/**
	 * variable to work with the base
	 */
	@Autowired
	private JdbcTemplate jdbc;

	public static class workingWithRowMap implements RowMapper<Shop> {
		/**
		 * copy data from DB to store
		 */
		public Shop mapRow(ResultSet rs, int rowNum) throws SQLException {
			Shop shop = new Shop();
			shop.setId(rs.getInt(1));
			shop.setAddress(rs.getString(2));

			return shop;
		}
	}

	/**
	 * Looking information about store by id
	 * 
	 * @param id
	 * @return store
	 */
	public Shop searchByIdShop(int id) {
		final String SQL = "SELECT * FROM Shop WHERE id=?";
		Shop shop = jdbc.queryForObject(SQL, new workingWithRowMap(), id);
		return shop;
	}
	
	/**
	 * Select all information about store
	 * @param page
	 * @return store
	 */
	public Collection<Shop> infoAboutShop(int page) {
		page *= 2;
		final String SQL = "SELECT * FROM Shop LIMIT 2 offset ?";
		List<Shop> shop = jdbc.query(SQL, new workingWithRowMap(), page);
		return shop;
	}

	public void addShop(Shop shop) {
		final String SQL = "INSERT INTO Shop (Address) values (?) ";
		final String address = shop.getAddress();

		jdbc.update(SQL, new Object[] { address });
	}

}