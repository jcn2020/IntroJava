package com.sb.com.sb.inherit;

import com.sb.inherit.abs.AbstractAccount;

public class SavingsAccount extends AccountOriginal {
	
	private double interestRate = .1;
	
	public SavingsAccount(String name, double initialAmount) {
		/*
		if(initialAmount < 500 ) {
			
		}
		*/
		super(name, initialAmount);
	}
	
	
	@Override
	public void monthEnd() {
		double interest = getBalance() * interestRate;
		deposit(interest);
		
		System.out.println("SavingsAccount.monthEnd");
	}

}
