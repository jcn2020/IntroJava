package human;

public class UniversityPerson extends Person {
	private boolean isTeacher;
	
	public UniversityPerson(String firstName, String lastName, boolean isMale, int birthDay, int birthMonth, boolean isTeacher) {
		super(firstName, lastName, isMale, birthDay, birthMonth);
		this.isTeacher = isTeacher;
	}
	
	@Override
	public String getHandle() {
		return isTeacher ? "Prof." : "Dr.";
	}
}
