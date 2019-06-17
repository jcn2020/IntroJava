package com.sb.domain;

import org.apache.log4j.Logger;

import com.sb.BankException;

public abstract class AbstractAccount implements Account {
	private double balance;
	private String acctNumber;
	private int id;
	
	protected static double interestRate = .1;
	
	Logger logger = Logger.getLogger(getClass());

	private static int nextId = 1;
	
	public AbstractAccount(double balance, String acctNumber) {
		fakeSetBalance(balance);
		this.acctNumber = acctNumber;
		
		id = nextId++;
	}
	
	public AbstractAccount(String an) {
		this(0, an);
	}

	
	@Override
	public void setId(int id) {
		this.id = id;
	}

	@Override
	public int getId() {
		return id;
	}

	@Override
	public double getBalance() {
		return balance;
	}

	@Override
	public void setBalance(double balance) {
		if (balance > -1) {
			this.balance = balance;
		}
	}

	@Override
	public String getAcctNumber() {
		return acctNumber;
	}

	@Override
	public void setAcctNumber(String acctNumber) {
		if (acctNumber != null) {
			this.acctNumber = acctNumber;
		}
		
	}
	
	public static int getNextId() {
		return nextId;
	}
	

	@Override
	public abstract void monthEnd();

	@Override
	public String toString() {
		return "Account [balance=" + balance + ", acctNumber=" + acctNumber + ", id=" + id + "]";
	}

	public void fakeSetBalance(double balance) throws BankException {
		if (balance > -1) {
			this.balance = balance;
		}
		else {
			logger.info("Balance was negative: " + balance);
			throw new BankException("balance can not be negative: " + balance);
		}
		
		//Lots of other code here
	}
}
