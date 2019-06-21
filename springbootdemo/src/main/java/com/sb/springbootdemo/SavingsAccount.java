package com.sb.springbootdemo;

public class SavingsAccount extends AbstractAccount {
	
	private double interestRate = .1;
	
	public SavingsAccount(String name, double initialAmount) {
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
		
		System.out.println("com.sb.springbootdemo.SavingsAccount.monthEnd");
	}

}
