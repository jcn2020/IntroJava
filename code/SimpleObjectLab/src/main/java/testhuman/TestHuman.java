package testhuman;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import human.Person;

public class TestHuman {

	public static void testAllBirthdays(Person[] people, int day, int month) {
		boolean found = false;
		for (int i = 0; i < people.length; i++) {
			if (people[i].isBirthday(day, month)) {
				System.out.println(day + "/" + month + " is the birthday of " + people[i].getFormalAddress());
				found = true;
			}
		}
		if (!found) {
			System.out.println(day + "/" + month + " is nobody's birthday.");
		}

	}

	/**
	 * Use Stream.peek() to print while streaming the array.  
	 * 
	 * @param people
	 * @param day
	 * @param month
	 */
	public static void testAllBirthdaysLambda(Person[] people, int day, int month) {
		List<Person> persons = Arrays.stream(people)
			.filter(p -> p.isBirthday(day, month))
			.peek((person) -> System.out.println(day + "/" + month + " is the birthday of " + person.getFormalAddress()))
			.collect(Collectors.toList());
		
		if(persons.size() == 0) {
			System.out.println(day + "/" + month + " is nobody's birthday.");
		}

		//or
		long count = Arrays.stream(people)
			.filter(p -> p.isBirthday(day, month))
			.peek((person) -> System.out.println(day + "/" + month + " is the birthday of " + person.getFormalAddress()))
			.collect(Collectors.counting());

		if(count == 0) {
			System.out.println(day + "/" + month + " is nobody's birthday.");
		}
	}

	public static void main(String[] args) {
		Person[] people = { new Person("Fred", "Jones", true), 
				new Person("Jim", "Smith", true, 14, 3),
				new Person("Marcy", "Poller", true, 14, 3),
				new Person("Sheila", "Flemming", false), 
				new Person("Daisy", "Hemmingway", false, 21, 9) };

		System.out.println("Guests are:");
		for (int i = 0; i < people.length; i++) {
			System.out.println(people[i].getFormalAddress());
		}

		testAllBirthdays(people, 14, 3);
		testAllBirthdays(people, 9, 9);
		testAllBirthdays(people, 14, 9);
		testAllBirthdays(people, 21, 9);
		testAllBirthdays(people, 0, 0);

		System.out.println("Lambda Land");
		testAllBirthdaysLambda(people, 14, 3);
		testAllBirthdaysLambda(people, 9, 9);
		testAllBirthdaysLambda(people, 14, 9);
		testAllBirthdaysLambda(people, 21, 9);
		testAllBirthdaysLambda(people, 0, 0);
	}
}
