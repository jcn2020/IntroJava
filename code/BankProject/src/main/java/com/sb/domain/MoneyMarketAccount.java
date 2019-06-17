package com.sb.domain;

public class MoneyMarketAccount extends AbstractAccount {

	
	public MoneyMarketAccount(double balance, String acctNumber) {
		super(balance, acctNumber);
	}

	@Override
	public void monthEnd() {
	}

}
