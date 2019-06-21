package com.sb.springbootdemo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootdemoApplicationTests {

	@Autowired
	private BankController bc;

	@Test
	public void testGetAll() {
	    //BankController bc = new BankController();
		List<Account> accounts = bc.getAll();

		assertEquals(5, accounts.size());
	}

}
