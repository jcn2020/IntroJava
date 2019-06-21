package com.sb.enumexceptions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class EnumApp {

	public static void main(String[] args) {
		// enumDemo();
		//exceptions();
		runtimeExceptions();
		//EnumApp ea = new EnumApp();
		//ea.getFromFileWithReources("pom.xml");
	}
	
	public static void runtimeExceptions() {
		try {
			Account a = new SavingsAccount("Joe", 0);
		}
		catch(BankException e) {
			
		}
	}

	public static void exceptions() {

		List<Account> accounts = new ArrayList<>();
		try {
			Account a = new SavingsAccount("Joe", 0);

			System.out.println("New Account is " + a);
			accounts.add(a);
		} catch (BankException e) {
			System.out.println(e.getMessage());
			// e.printStackTrace();
		} catch (Exception e) {
			System.out.println("Unexpected Exception " + e);
		}

		// Resumes At this line
	}

	public int getFromFile(String fileName) {

		FileInputStream fis = null;
		try {
			fis = new FileInputStream(fileName);
			int val = fis.read();

			return val;

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fis.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return -1;
	}
	
	class MyClass implements AutoCloseable
	{

		@Override
		public void close() {
			System.out.println("MyClose.close called");
		}
		
	}

	public int getFromFileWithReources(String fileName) {

		try (FileInputStream fis = new FileInputStream(fileName);
				MyClass mc = new MyClass()) {
			int val = fis.read();

			return val;
			
		} catch (IOException e) {
			e.printStackTrace();
		}

		return -1;
	}

	public static void enumDemo() {

		Status[] allStatuses = Status.values();
		for (Status status : allStatuses) {
			System.out.println(status + ", code is " + status.getCode());
		}

		String name = "Shirley";
		double balance = 29292;
		// String statStr = "ACTIVE";

		String statStr = "Active";

		Status status = Status.valueOf(statStr.toUpperCase());

		System.out.println("Converted status" + status);

		// Account a = new CheckingAccount("Joe", 38383, "ACTIVE");
		// Account a = new CheckingAccount("Joe", 38383, AbstractAccount.STATUS_ACTIVE);
		List<Account> accounts = new ArrayList<>();

		Account a = new CheckingAccount("Joe", 38383, Status.ACTIVE);
		accounts.add(a);

		// Account a2 = new CheckingAccount("Joe", 38383, "ACTIV");
		Account a2 = new CheckingAccount("Joe", 38383, Status.ABANDONED);

		accounts.add(a2);

	}

}
