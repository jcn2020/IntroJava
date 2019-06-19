package com.sb.inherit;

public class SavingsAccount extends Account {
	
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
