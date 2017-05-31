package com.coffeeshop.components.entity;

import java.sql.Date;

/**
 * 
 * @author dynamic
 *
 *Contains information about Order
 *
 */
public class Order {
	private Long idOrder;
	private Long idCoffee;
	private Date dateOrder;
	
	public Long getId(){
		return idOrder;
	}
	
	public void setId(Long idorder){
		this.idOrder = idorder;
	}
	
	public Long getIdCoffee(){
		return idCoffee;
	}
	
	public void setIdCoffee(Long idcoffee){
		this.idCoffee = idcoffee;
	}
	
	public Date getDateorder(){
		return dateOrder;
	}
	
	public void setDateorder(Date dateorder){
		this.dateOrder=dateorder;
	}

	
}

