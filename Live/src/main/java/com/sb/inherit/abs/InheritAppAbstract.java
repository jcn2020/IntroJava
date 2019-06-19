package com.sb.inherit.abs;

public class InheritAppAbstract {
	
	public static void main(String[] args) {
		//testMonthEnd();
		//polymorphicArray();
		//testToString();
		equalsTests();
	}

	public static void equalsTests() {
		String s1 = "hello";
		String s2 = new String("hello");

//		if(s1.equals(s2)) {
//			System.out.println("Equal");
//		}
//		else {
//			System.out.println("Not Equal");
//		}

		Account a1 = new CheckingAccount("Joe", 2345);

		Account a2 = new CheckingAccount("Joe", 2345);

		if(a1.equals(a2)) {
			System.out.println("Equal");
		}
		else {
			System.out.println("Not Equal");
		}

	}
	
	public static void testToString() {
		int i = 10;
		Account a = new SavingsAccount("Sam", 28282);
		System.out.println(i + ", " + a);
	}
	
	public static void polymorphicArray()  {
		Account[] accounts = new Account[4];
		
		accounts[0] = new SavingsAccount("Sam", 28282);
		accounts[1] = new CheckingAccount("Sabina", 28282);
		accounts[2] = new SavingsAccount("Roshan", 28282);
		accounts[3] = new SavingsAccount("Green", 3839);
		
		
		for(Account account : accounts) {
			account.monthEnd();
			
			if(account instanceof com.sb.com.sb.inherit.CheckingAccount) {
				com.sb.com.sb.inherit.CheckingAccount ca = (com.sb.com.sb.inherit.CheckingAccount)account;
				ca.foo();
			}
		}
	}

	public static void testMonthEnd() {
		Account a = new SavingsAccount("Joe", 600);
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
		Account a = new CheckingAccount("Joe", 600);
		boolean b = a.withdraw(400);

		a.monthEnd();

		System.out.println("400 from AbstractAccount is " + b);
		System.out.println("a balance is " + a.getBalance());
		
		CheckingAccount ca = new CheckingAccount("Shanthi", 600);

		boolean b2 = ca.withdraw(400);
		
		System.out.println("ca balance is " + ca.getBalance());
		
		
	}

}
