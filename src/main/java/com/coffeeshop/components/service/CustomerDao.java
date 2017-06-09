package com.coffeeshop.components.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.coffeeshop.components.entity.Customer;
import com.coffeeshop.components.interface_i.ICustomer;


@Repository
public class CustomerDao implements ICustomer{
	/**
	 * variable to work with the base
	 */
	@Autowired
	private JdbcTemplate jdbc;

	public static class workingWithRowMap implements RowMapper<Customer> {
		/**
		 * copy data from DB to customer
		 */
		public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
			Customer customer = new Customer();
			customer.setCustomerId(rs.getInt(1));
			customer.setSurname(rs.getString(2));
			customer.setName(rs.getString(3));	
			customer.setEmail(rs.getString(4));
			customer.setCreditcard(rs.getString(5));
			

			return customer;
		}
	}

	/**
	 * Looking information about customer by id
	 * 
	 * @param id
	 * @return customer
	 */
	public Customer searchByIdCustomer(int id) {
		final String SQL = "SELECT * FROM Customer WHERE id=?";
		Customer customer = jdbc.queryForObject(SQL, new workingWithRowMap(), id);
		return customer;
	}
	
	/**
	 * Select all information about customer
	 * @param page
	 * @return customer
	 */
	public Collection<Customer> searchCustomers(int page) {
		page *= 3;
		final String SQL = "SELECT * FROM Customer LIMIT 3 offset ?";
		List<Customer> customer = jdbc.query(SQL, new workingWithRowMap(), page);
		return customer;
	}

	public void addCustomer(Customer customer) {
		final String SQL = "INSERT INTO Customers (Surname, Name,  email, creditcard) values (?, ?, ?, ?) ";
		final String surName = customer.getSurname();
		final String name = customer.getName();	
		final String email = customer.getEmail();
		final String creditcard = customer.getCreditcard();

		jdbc.update(SQL, new Object[] { surName, name, email, creditcard});
	}

	
	
	}
