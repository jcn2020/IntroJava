package com.sb.lab04;

public class Person {

	private String firstName;
	private String lastName;
	private Gender gender;
	
	public enum Gender
	{
		MALE,
		FEMALE,
		OTHER
	}

	private int month;
	private int day;


	public Person() {
	}

	public Person(String firstName, String lastName, Gender gender, int month, int day) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.month = month;
		this.day = day;
	}

	public Person(String firstName, String lastName, Gender gender) {
		this(firstName, lastName, gender, 0, 0);
	}

	public String getFullName() {
		return getFirstName() + " " + getLastName();
	}
	
	public String getFormalAddress() {
		String fa = getSalutation() + " " + getFullName();
		return fa;
	}

	public String getSalutation() {
		switch (gender) {
		//case "Male":
		case MALE:
			return "Mr.";
		//case "Female":
		case FEMALE:
			return "Ms.";

		case OTHER:
			return "O.";
		}
		
		return "";
		
		
	}
	
	public boolean isBirthday(int month, int day) {
		if(this.month == month && this.day == day) {
			return true;
		}
		return false;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

}
