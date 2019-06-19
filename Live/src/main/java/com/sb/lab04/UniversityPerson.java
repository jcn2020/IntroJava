package com.sb.lab04;

public class UniversityPerson extends Person {

    private boolean isTeacher;

    public UniversityPerson(String firstName, String lastName, String gender,
                            int month, int day, boolean isTeacher) {
        super(firstName, lastName, gender, month, day);

        this.isTeacher = isTeacher;
    }


    public UniversityPerson(String firstName, String lastName, String gender, boolean isTeacher) {
        //super(firstName, lastName, gender, 0, 0);
        this(firstName, lastName, gender, 0, 0, isTeacher);
    }

    public boolean isTeacher() {
        return isTeacher;
    }

    public void setTeacher(boolean teacher) {
        isTeacher = teacher;
    }

    @Override
    public String getSalutation() {
        return isTeacher ? "Professor" : "Dr." ;
    }
}
