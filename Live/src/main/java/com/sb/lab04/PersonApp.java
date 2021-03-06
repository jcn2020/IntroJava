package com.sb.lab04;

import java.time.LocalDate;

import com.sb.lab04.Person.Gender;

public class PersonApp {

	public static void main(String[] args) {
		Person[] persons = {
				//new Person("Sam", "Smith", "Male", 2, 23),
				new Person("Sam", "Smith", Gender.FEMALE, 2, 23),
				new UniversityPerson("Charlie", "Daniels", Gender.MALE,
						2, 23, true)
		};

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
