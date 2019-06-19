package com.sb.inherit;

public class InheritApp {
	
	public static void main(String[] args) {
		//testMonthEnd();
		//polymorphicArray();
		testToString();
	}
	
	public static void testToString() {
		int i = 10;
		Account a = new Account("Sam", 28282);
		System.out.println(i + ", " + a);
	}
	
	public static void polymorphicArray()  {
		Account [] accounts = new Account[4];
		
		accounts[0] = new Account("Sam", 28282);
		accounts[1] = new CheckingAccount("Sabina", 28282);
		accounts[2] = new SavingsAccount("Roshan", 28282);
		accounts[3] = new SavingsAccount("Green", 3839);
		
		
		for(Account account : accounts) {
			account.monthEnd();
			
			if(account instanceof CheckingAccount) {
				CheckingAccount ca = (CheckingAccount)account;
				ca.foo();
			}
		}
	}

	public static void testMonthEnd() {
		Account a = new Account("Joe", 600);
		a.monthEnd();
		
		System.out.println("a balance is " + a.getBalance());
		
		CheckingAccount ca = new CheckingAccount("Shanthi", 600);
		ca.withdraw(20);
		System.out.println("ca balance is " + ca.getBalance());
		
		

		Account account = ca;
		account.withdraw(20);
		
		Object o = ca;

		
		SavingsAccount sa = new SavingsAccount("Cruz", 600);
		sa.monthEnd();
		System.out.println("sa balance is " + sa.getBalance());
		
		
	}
	
	public static void testWithdraw() {
		Account a = new Account("Joe", 600);
		boolean b = a.withdraw(400);
		
		System.out.println("400 from Account is " + b);
		System.out.println("a balance is " + a.getBalance());
		
		CheckingAccount ca = new CheckingAccount("Shanthi", 600);

		boolean b2 = ca.withdraw(400);
		
		System.out.println("ca balance is " + ca.getBalance());
		
		
	}

}
