package com.sb.com.sb.collection;

public class CheckingAccount extends AbstractAccount {
	
	private double minBalance = 500;
	
	public CheckingAccount(String name, double initialAmount) {
		super(name, initialAmount);
	}

	@Override
	public boolean withdraw(double amt) {
		if( getBalance() > amt + minBalance) {
			return super.withdraw(amt);
		}
		
		return false;
	}

	public void foo() {
		
	}

	@Override
	public void monthEnd() {
		System.out.println("Month End");
	}

}
