package com.sb.domain;

public class BankApp {

	public static void main(String[] args) {
		Account a1 = new Account(2, "Joe", 33333.00);
		Account a2 = new Account(3, "Charlene", 38383.93);
		
		System.out.println("a1.name is " + a1.getName());
		
		
		a2.withdraw(100000000);
				
	}
}
