package com.sb.springbootdemo;

import java.util.Comparator;

public interface Account extends Comparable<Account> {

	/*
	public enum com.sb.springbootdemo.Status {
		ACTIVE,
		INACTIVE,
		ABANDONED
	}
	*/

    static class NameComparator implements Comparator<Account> {
        @Override
        public int compare(Account account1, Account account2) {
            return account2.getName().compareTo(account1.getName());
        }
    }

    public static NameComparator nameComp = new NameComparator();

    public static final int MAX_ID = Integer.MAX_VALUE;

    public static int doSomething() {
        System.out.println("Somthing");
        return 10;
    }


    public int getId();
    public String getName();
    public double getBalance();

    public boolean withdraw(double amount);
    public void deposit(double amount);
    public void monthEnd();


    public default void monthMiddle() {
        throw new UnsupportedOperationException("monthMiddle not supported");
//        double b = getBalance();
//        if(b < 500) {
//            //send email about low balance
//        }
    }



}
