package com.sb.springbootdemo;

import java.util.Objects;

public abstract class AbstractAccount implements Account {
	private int id;
	private String name;
	private double balance;
	
	//One of ACTIVE, INACTIVE, ABANDONED
	/*
	public static final String STATUS_ACTIVE = "ACTIVE";
	public static final String STATUS_INACTIVE = "INACTIVE";
	public static final String STATUS_ABANDONED = "ABANDONED";
	*/


	//private String status;
	private Status status;

	private static int nextId;

	static {
		nextId = 1;
	}


	public AbstractAccount() {
	}

	public AbstractAccount(String name, double initialBalance) {
		//this(-1, n, b);
		if(initialBalance <= 0) {
			throw new BankException("Initial Balance is too low: " + initialBalance);
		}
		
		init(name, initialBalance, Status.ACTIVE);
	}
	
	public AbstractAccount(String name, double initialBalance, Status status) {
		init(name, initialBalance, status);
	}
	
	protected void init(String name, double initialBalance, Status status) {
		this.id = nextId++;

		this.name = name;
		
		//Go To DataBase and get info
		this.balance = initialBalance;
		this.status = status;

	}
	public int foo(int value) {
		if(value < 0) {
			return -1;
		}
		return value + 10;
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
	public com.sb.springbootdemo.AbstractAccount(int i, String n, double b) {
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
		return "com.sb.springbootdemo.AbstractAccount [id=" + id + ", name=" + name + ", balance=" + balance + ", status=" + status + "]";
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

	@Override
	public int compareTo(Account other) {
		if(this.id < other.getId()) {
			return -1;
		}
		else if(this.id == other.getId()) {
			return 0;
		}
		else {
			return 1;
		}
	}
}
