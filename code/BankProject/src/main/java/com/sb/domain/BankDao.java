package com.sb.domain;

public interface BankDao {

	Account insertAccount(Account a);

	Account findAccount(int id);

}