package com.sb.lambda;

//public class BankException extends Exception {
public class BankException extends RuntimeException {
	
	public BankException(String message) {
		super(message);
	}

}
