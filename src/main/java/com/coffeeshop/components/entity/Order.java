package com.coffeeshop.components.entity;


/**
 * 
 * @author dynamic
 *
 *Contains information about Order
 *
 */
public class Order {
	private int id;
	private int idStuff;
	private float totalSum;

	public Order() {
	}

	public Order(int id, int idStuff, float totalSum){
		this.id = id;
		this.idStuff = idStuff;
		this.totalSum = totalSum;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public int getIdStuff() {
		return idStuff;
	}

	public void setIdStuff(int idStuff) {
		this.idStuff = idStuff;
	}

	public float getTotalSum() {
		return totalSum;
	}

	public void setTotalSum(float totalSum) {
		this.totalSum = totalSum;
	}
}