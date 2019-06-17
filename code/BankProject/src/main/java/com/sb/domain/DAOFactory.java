package com.sb.domain;

public class DAOFactory {

	public static BankDao createBankDao() {
		//return new InMemoryBankDao();
		return new MysqlBankDAO();
	}
}
