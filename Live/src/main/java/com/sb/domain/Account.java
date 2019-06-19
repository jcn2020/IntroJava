package com.sb.domain;

import java.util.UUID;

public class Account {
	private int id;
	private String name;
	private double balance = 55;
	
	private static int nextId; 
	
	static {
		//read next Id from DB
		nextId = 1;
	}
	
	public static int getNextId() {
		
		UUID randomId = UUID.randomUUID();
		return nextId;
	}
	
	public Account() {
	}
	
	public Account(String name, double balance) {
		//this(-1, n, b);

		this.id = nextId++;

		this.name = name;
		
		//Go To DataBase and get info
		this.balance = balance;
	}
	
	public int getId() {
		return id;
	}
	/*
	public AbstractAccount(int i, String n, double b) {
		id = i;
		name = n;
		balance = b;
	}
	*/
	
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
