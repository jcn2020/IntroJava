package com.sb.domain;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class MysqlBankDAO implements BankDao {

	private Map<Integer, Account> accounts = new ConcurrentHashMap<>();
	private AtomicInteger nextId = new AtomicInteger(100);
	
	@Override
	public Account insertAccount(Account a) {
		int id = nextId.incrementAndGet();
		a.setId(id);
		
		//insert into DB
		accounts.put(id, a);

		return a;
	}
	
	@Override
	public Account findAccount(int id) {
		return accounts.get(id);
	}
}
