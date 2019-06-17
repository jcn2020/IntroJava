package com.sb.myapp.domain;

import com.sb.domain.AbstractAccount;

public class SavingsAccount extends AbstractAccount {

	private double minBalance = 500;
	private double bonus = 1;
	
	public SavingsAccount(double balance, String acctNumber) {
		super(balance, acctNumber);
	}

	@Override
	public void monthEnd() {
		setBalance(getBalance() * interestRate);
		if(getBalance() >= minBalance) {
			setBalance(getBalance() + bonus);
		}
	}
}
