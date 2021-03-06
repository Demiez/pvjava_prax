package com.petrenko.lab0302.entity;

import java.util.ArrayList;
import java.util.List;

public class User {

	public int id;
	public String name;
	public String password;
	public String email;
	public List<Invoice> purchases;
	
	public User() {
		super();
		this.purchases = new ArrayList<Invoice>();
	}

	public User(int id, String name, String password, String email) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.email = email;
		this.purchases = new ArrayList<Invoice>();
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public List<Invoice> getPurchases() {
		return purchases;
	}
	public void setPurchases(List<Invoice> purchases) {
		this.purchases = purchases;
	}
	public void addPurchase(Invoice purchase) {
		purchases.add(purchase);
	}
}
