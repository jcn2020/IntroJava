package com.sb.domain;

public class BankApp {

	int value;
	public static void main(String[] args) {
		
		BankApp ba = new BankApp();
		int x = ba.value++;

		//Account a1 = new Account(2, "Joe", 33333.00);
		//Account a2 = new Account(3, "Charlene", 38383.93);

		System.out.println("Next id is now " + Account.getNextId());

		Account a1 = new Account("Joe", 33333.00);
		Account a2 = new Account("Charlene", 38383.93);
		Account a3 = new Account("Manoj", 38383.93);
		
		System.out.println("Next id is now " + Account.getNextId());
	
		Account [] arr =  { a1, a2 , a3};
		
		Account [] ar2 = { new Account(), new Account() };
		
		for(int i = 0; i < arr.length; i++) {
			//arr[i] = new Account();
			System.out.println(arr[i].getName() + " has id " + arr[i].getId());
		}
		
				
	}
}
