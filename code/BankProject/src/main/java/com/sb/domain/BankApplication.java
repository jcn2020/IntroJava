package com.sb.domain;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BankApplication {

	public static void main(String[] args) {
		BankApplication ba = new BankApplication();

		ApplicationContext ctx = new ClassPathXmlApplicationContext("bankBeans.xml");
		
		ba.service = ctx.getBean("bankService", BankService.class);

		ba.firstRequest();
		ba.secondRequest();
		}
	
	BankService service;

	public void firstRequest() {
		double balance = 3200;
		String acctNumber = "282828";

		//Convert and validate as necessary
		
		
		Account a = new CheckingAccount(balance, acctNumber);
		
		a = service.createAccount(a);
		
		System.out.println(a);
		
	}

	public void secondRequest() {
		int idToFind = 1;

		//Convert and validate as necessary
		
		Account a = service.getAccount(idToFind);
		
		System.out.println(a);
		
	}
}
