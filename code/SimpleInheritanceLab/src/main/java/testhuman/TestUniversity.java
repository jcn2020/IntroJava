package testhuman;

import human.Person;
import human.UniversityPerson;

public class TestUniversity {

	public static void main(String[] args) {
		Person [] people = {
			new Person("Fred", "Jones", true),
			new Person("Jim", "Smith", true, 14, 3),
			new UniversityPerson("Sheila", "Flemming", false, 19, 8, true),
			new UniversityPerson("Daisy", "Hemmingway", false, 21, 9, false),
			new UniversityPerson("Andrew", "Thomas", true, 8, 4, true),
			new UniversityPerson("William", "Crawford", true, 7, 3, false)
		};
		
		System.out.println("Guests are:");
		for (int i = 0; i < people.length; i++) {
			System.out.println(people[i].getFormalAddress());
		}
	}
}
