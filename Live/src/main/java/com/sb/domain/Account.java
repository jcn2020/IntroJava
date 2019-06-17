package com.sb.domain;

public class Account {
	private int id;
	private String name;
	private double balance;
	
	public Account() {
	}
	
	public Account(String n, double b) {
		this(-1, n, b);
	}
	
	public Account(int i, String n, double b) {
		id = i;
		name = n;
		balance = b;
	}
	
	public double getBalance() {
		return balance;
	}
	
	public boolean withdraw(double amt) {
		if( balance > amt) {
			balance -= amt;
			return true;
		}
		
		return false;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
}
