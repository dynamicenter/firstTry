package com.coffeeshop.components.entity;
/**
 * 
 * @author dynamic
 *
 *Contains information about Coffee available 
 *
 */
public class Coffee {
	public int id;
	public String name;
	public int price;
	
	public Coffee() {
	}
	
	public Coffee(int id,String name,int price) {
		
		this.id=id;
		this.name=name;
		this.price=price;
	}
	
	public int getId(){
		return id;
	}
	
	public void setId(int id){
		this.id=id;
	}
	
	public String getName(){
		return name;
	}
	
	public void setName(String name){
		this.name=name;
	}
	
	public int getPrice(){
		return price;
	}
	
	public void setPrice(int price){
		this.price=price;
	}
	
	
	
	
	
	
	
	
	
	
	
}
