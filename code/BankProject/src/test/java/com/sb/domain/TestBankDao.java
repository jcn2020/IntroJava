package com.sb.domain;

import static org.junit.Assert.*;

import org.junit.Test;

import com.sb.myapp.domain.SavingsAccount;

public class TestBankDao {
	
	@Test
	public void testInsertAccount() {
		BankDao bd = new InMemoryBankDao();
		
		Account a = new SavingsAccount(383, "2829");
		a = bd.insertAccount(a);
		
		int id = a.getId();
		assertEquals(1, id);
		
		a = bd.findAccount(id);
		
		assertNotNull(a);
	}

}
