package exercise;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

import support.RandomStringFactory;

public class ListExerciser {
	private static int COUNT = 250000;

	List<String> l;
	String[] s;

	public ListExerciser(List<String> list) {
		s = new String[COUNT];
		for (int i = 0; i < COUNT; i++) {
			s[i] = RandomStringFactory.makeRandomString(8);
		}
		this.l = list;
	}

	public void measureAppend() {
		l.clear();
		long startTime = System.currentTimeMillis();
		for (int i = 0; i < s.length; i++) {
			l.add(s[i]); // append to the end of the list
		}
		long endTime = System.currentTimeMillis();
		System.out.println("Time for appends to " + l.getClass().getName()
				+ " is " + (endTime - startTime) + " milliseconds");
	}

	public void measureInsert() {
		l.clear();
		long startTime = System.currentTimeMillis();
		for (int i = 0; i < s.length; i++) {
			l.add(0, s[i]); // insert at the beginning of the list
		}
		long endTime = System.currentTimeMillis();
		System.out.println("Time for inserts into " + l.getClass().getName()
				+ " is " + (endTime - startTime) + " milliseconds");
	}

	public void measureReplace() {
		assert l.size() == COUNT; // must be called after the list is filled
		long startTime = System.currentTimeMillis();
		for (int i = COUNT - 1; i >= 0; i--) {
			l.set(i, s[i]);
		}
		long endTime = System.currentTimeMillis();
		System.out.println("Time for replacements  in "
				+ l.getClass().getName() + " is " + (endTime - startTime)
				+ " milliseconds");
	}


	public void measureReplaceWithIterator() {
		assert l.size() == COUNT; // must be called after the list is filled
		long startTime = System.currentTimeMillis();

		ListIterator<String> li = l.listIterator();
		while (li.hasNext()) li.next(); // get to the end...
		int i = -1;
		while (li.hasPrevious()) {
			li.previous();
			li.set("Re-set: " + i--);
		}
		long endTime = System.currentTimeMillis();
		System.out.println("Time for replacements with ListIterator in "
				+ l.getClass().getName() + " is " + (endTime - startTime)
				+ " milliseconds");
	}


	public static void main(String[] args) {
		ArrayList<String> al = new ArrayList<String>();
		LinkedList<String> ll = new LinkedList<String>();
		ListExerciser le1 = new ListExerciser(al);
		ListExerciser le2 = new ListExerciser(ll);

		le1.measureAppend();
		le2.measureAppend();

		le1.measureInsert();
		le2.measureInsert();

		le1.measureReplace();
		le2.measureReplace();
		
		le1.measureReplaceWithIterator();
		le2.measureReplaceWithIterator();
	}
}
