package com.sb.inherit.abs;

import java.util.Objects;

public abstract class AbstractAccount implements Account{
	private int id;
	private String name;
	private double balance;

	private static int nextId;

	static {
		nextId = 1;
	}


	/*
	public AbstractAccount() {
	}
	*/

	public AbstractAccount(String name, double balance) {
		//this(-1, n, b);

		this.id = nextId++;

		this.name = name;
		
		//Go To DataBase and get info
		this.balance = balance;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public static int getNextId() {
		return nextId;
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

	@Override
	public boolean withdraw(double amt) {
		if( balance > amt) {
			balance -= amt;
			return true;
		}
		
		return false;
	}

	public void deposit(double amt) {
		balance += amt;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public abstract void monthEnd();

	@Override
	public String toString() {
		return "AbstractAccount [id=" + id + ", name=" + name + ", balance=" + balance + "]";
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		AbstractAccount account = (AbstractAccount) o;
		return id == account.id &&
				Double.compare(account.balance, balance) == 0 &&
				Objects.equals(name, account.name);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name, balance);
	}
}
