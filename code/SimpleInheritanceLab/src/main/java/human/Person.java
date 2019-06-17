package human;

public class Person {
	private String firstName;
	private String lastName;
	private boolean isMale;
	private int birthDay;
	private int birthMonth;
	
	public String getFullName() {
		return firstName + " " + lastName;
	}
	
	public String getHandle() {
		return isMale ? "Mr." : "Ms.";
	}
	
	public String getFormalAddress() {
		return getHandle() + " " + getFullName();
	}
	
	public boolean isBirthday(int day, int month) {
		return birthDay != 0 && birthMonth != 0 
			&& birthDay == day && birthMonth == month;
	}
	
	public Person(String first, String last, boolean isMale) {
		firstName = first;
		lastName = last;
		this.isMale = isMale;
	}
	
	public Person(String first, String last, boolean isMale, int birthDay, int birthMonth) {
		this(first, last, isMale);
		this.birthDay = birthDay;
		this.birthMonth = birthMonth;
	}
}
