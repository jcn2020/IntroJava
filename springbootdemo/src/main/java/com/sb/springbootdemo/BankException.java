package com.sb.springbootdemo;

//public class com.sb.springbootdemo.BankException extends Exception {
public class BankException extends RuntimeException {
	
	public BankException(String message) {
		super(message);
	}

}
