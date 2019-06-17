package com.sb.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.sb.BankException;

public class TestAccount {

	@BeforeClass
	public static void beforeEverything() {
		
	}

	@Before
	public void init() {
		
	}
	@After
	public void tearDown() {
		
	}

	@Test
	public void testIdGeneration() {
		Account a1 = new CheckingAccount(2000, "38383");
		Account a2 = new CheckingAccount(2000, "38383");
		
		assertTrue("Sequence not working", a1.getId() == a2.getId() - 1);
	}

	@Test
	public void testPositiveBalance() {
		Account a1 = new CheckingAccount(2000, "38383");
		
		assertEquals(2000, a1.getBalance(), .00001);
	}

	@Test(expected = BankException.class)
	public void testNegative() {
		Account a1 = new CheckingAccount(-2000, "38383");
		
		assertEquals(-2000, a1.getBalance(), .00001);
	}
}
