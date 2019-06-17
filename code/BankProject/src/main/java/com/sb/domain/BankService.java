package com.sb.domain;

public class BankService {

	
	private BankDao dao; // = new InMemoryBankDao();

	public Account getAccount(int id) {
		Account a = dao.findAccount(id);
		return a;
	}

	public Account createAccount(Account a) {
		//Lots of other work maybe
		a = dao.insertAccount(a);
		return a;
	}
	
	public void setBankDao(BankDao dao) {
		this.dao = dao;
	}
}
