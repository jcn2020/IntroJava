package com.sb.lambda;

public interface Account {

	/*
	public enum Status {
		ACTIVE,
		INACTIVE,
		ABANDONED
	}
	*/

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
