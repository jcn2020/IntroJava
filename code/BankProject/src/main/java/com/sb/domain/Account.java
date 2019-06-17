package com.sb.domain;

public interface Account {

	public static double interestRate = .1;
	
	public abstract int getId();
	
	public void setId(int id);

	double getBalance();

	void setBalance(double balance);

	String getAcctNumber();

	void setAcctNumber(String acctNumber);

	void monthEnd() ;
	
}