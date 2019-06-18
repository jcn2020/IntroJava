package com.sb.domain;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BankApplication {

	private static Logger logger = Logger.getLogger(BankApplication.class);

	public static void main(String[] args) {
		BankApplication ba = new BankApplication();

		ApplicationContext ctx = new ClassPathXmlApplicationContext("bankBeans.xml");

		ba.service = ctx.getBean("bankService", BankService.class);

		ba.firstRequest();
		ba.secondRequest();
		
		logger.info("Banker all done");
	}

	BankService service;

	public void firstRequest() {
		double balance = 3200;
		String acctNumber = "282828";

		// Convert and validate as necessary

		Account a = new CheckingAccount(balance, acctNumber);

		a = service.createAccount(a);

		System.out.println(a);

	}

	public void secondRequest() {
		int idToFind = 1;

		// Convert and validate as necessary

		Account a = service.getAccount(idToFind);

		System.out.println(a);

	}
}
