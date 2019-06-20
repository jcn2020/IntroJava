package com.sb.enumexceptions;

//public class BankException extends Exception {
public class BankException extends RuntimeException {
	
	public BankException(String message) {
		super(message);
	}

}
