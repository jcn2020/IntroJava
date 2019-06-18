package com.sb.lab03;

import java.time.LocalDate;

public class PersonApp {

	public static void main(String[] args) {
		Person [] persons2 = { new Person("Sam", "Smith", "Male", 2, 23) };
		
		
		
		Person [] persons = new Person[3];
		
		Person p = new Person("Sam", "Smith", "Male", 6, 18);
		persons[0] = p;

		p = new Person("Stork", "Smith", "Male", 2, 15);

		persons[1] = p;
		
		p = new Person("Rachna", "Smith", "Female");
		persons[2] = p;
		
		for(Person person : persons) {
			System.out.println(person.getFormalAddress());
			LocalDate now = LocalDate.now();
			int month = now.getMonthValue();
			int day = now.getDayOfMonth();
			
			boolean b = person.isBirthday(month, day);

			String str = b ? "Is" : "Is Not";

			System.out.println("Today " + str + " " + person.getFirstName() + "'s birthday");
					
		}
		
	}
}
