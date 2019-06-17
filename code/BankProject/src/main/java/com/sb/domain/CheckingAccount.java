package com.sb.domain;

import com.sb.BankException;

public final class CheckingAccount extends AbstractAccount {

	private static final double MIN_BALANCE = 500;
	private static final double FEE = 10;
	
	public CheckingAccount(double balance, String acctNumber) {
		super(balance, acctNumber);
	}

	@Override
	public void monthEnd() {
		if(getBalance() < MIN_BALANCE) {
			setBalance(getBalance() - FEE);
		}
	}
}
