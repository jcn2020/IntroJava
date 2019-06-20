package com.sb.enumexceptions;

import java.util.*;

public class EnumApp {
	
	public static void main(String[] args) {
		enumDemo();

	}
	
	public static void enumDemo() {
		
		Status [] allStatuses = Status.values();
		for(Status status : allStatuses) {
			System.out.println(status + ", code is " + status.getCode());
		}
		
		String name = "Shirley";
		double balance = 29292;
		//String statStr = "ACTIVE";

		String statStr = "Active";

		Status status = Status.valueOf(statStr.toUpperCase());
		
		System.out.println("Converted status" + status);

		
		//Account a = new CheckingAccount("Joe", 38383, "ACTIVE");
		//Account a = new CheckingAccount("Joe", 38383, AbstractAccount.STATUS_ACTIVE);
		List<Account> accounts = new ArrayList<>();

		Account a = new CheckingAccount("Joe", 38383, Status.ACTIVE);
		accounts.add(a);
		
		//Account a2 = new CheckingAccount("Joe", 38383, "ACTIV");
		Account a2 = new CheckingAccount("Joe", 38383, Status.ABANDONED);
		
		accounts.add(a2);
		
		
	}

}
