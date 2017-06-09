package com.coffeeshop.components.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.coffeeshop.components.entity.Order;
import com.coffeeshop.components.interface_i.IOrder;

@Repository
public class OrderDao implements IOrder{
	/**
	 * variable to work with the base
	 */
	@Autowired
	private JdbcTemplate jdbc;

	public static class workingWithRowMap implements RowMapper<Order> {
		/**
		 * copy data from DB to order
		 */
		public Order mapRow(ResultSet rs, int rowNum) throws SQLException {
			Order order = new Order();
			order.setId(rs.getInt(1));
			order.setIdStuff(rs.getInt(4));
			order.setTotalSum(rs.getInt(5));

			return order;
		}
	}
	
	public Collection<Order> infoAboutOrder(int page) {
		page *= 3;
		final String SQL = "SELECT * FROM Order LIMIT 3 offset ?";
		List<Order> order = jdbc.query(SQL, new workingWithRowMap(), page);
		return order;
	}
	
	/**
	 * Looking information about  order by order id
	 * 
	 * @param id
	 * @return order
	 */
	public Order searchByIdOrder(int id) {
		final String SQL = "SELECT * from Orders WHERE id=?";
		Order order = jdbc.queryForObject(SQL, new workingWithRowMap(), id);
		return order;
	}
	
	public void createOrder(Order order) {
		final String SQL = "INSERT INTO Orders ( idWorker, TotalSum) values (?, ?) ";	
		final int id = order.getIdStuff();
		final float totalSum = order.getTotalSum();

		jdbc.update(SQL, new Object[] { id, totalSum });
	}


}