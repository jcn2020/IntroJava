package com.sb.enumexceptions.xyz;

import com.sb.enumexceptions.AbstractAccount;
import com.sb.enumexceptions.BankException;
import com.sb.enumexceptions.Status;

public class MoneyMarketAccount extends AbstractAccount {
	
	private double interestRate = .1;
	
	public MoneyMarketAccount(String name, double initialAmount) {
		if(initialAmount < 500 ) {
			throw new BankException("InitialAmount is too low: " + initialAmount);
		}
		//super(name, initialAmount);
		super.init(name, initialAmount, Status.ACTIVE);
	}
	
	
	@Override
	public void monthEnd() {
		double interest = getBalance() * interestRate;
		deposit(interest);
		
		System.out.println("SavingsAccount.monthEnd");
	}

}
