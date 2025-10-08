package org.example.people;

public class Student extends BasePerson {

    private String school;
    public Student(String uuid, String firstName, String lastName, String school) {
        super(uuid, firstName, lastName);
        this.school = school;
    }

    public String getSchool() {
        return school;
    }
}
