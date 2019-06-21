package com.sb.springbootdemo;

public enum Status {
	ACTIVE(32), 
	INACTIVE(45), 
	ABANDONED(999);
	
	private int code;
	
	Status(int code) {
		this.code = code;
	}
	
	public int getCode() {
		return code;
	}
	
	@Override
	public String toString() {
		
		String origName = name();
		String result = origName.substring(0, 1) + origName.substring(1).toLowerCase();
		
		return result;
	}
}
