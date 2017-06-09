package com.coffeeshop.components.entity;

public class Customer {
	private int id;
	private String name;
	private String surname;
	private String email;
	private String creditcard;
	
	public Customer() {
	}
	
	public Customer(int id, String surname,String email, String name, String creditcard){
		this.id = id;
		this.surname = surname;
		this.name = name;
		this.email = email;
		this.creditcard = creditcard;
	}
	public int getCustomerId(){
		return id;
	}
	
	public void setCustomerId(int id){
		this.id=id;
	}
	
	public String getName(){
		return name;
	}
	
	public void setName(String name){
		this.name=name;
	}
	
	public String getSurname(){
		return surname;
	}
	
	public void setSurname(String surname){
		this.surname=surname;
	}
	
	public String getEmail(){
		return email;
	}
	
	public void setEmail(String email){
		this.email=email;
	}
	
	public String getCreditcard(){
		return creditcard;
	}
	
	public void setCreditcard(String creditcard){
		this.creditcard=creditcard;
	}
}

