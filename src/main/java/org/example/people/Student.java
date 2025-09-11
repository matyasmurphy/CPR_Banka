package org.example.people;

import org.example.bankAccounts.BaseBankAccount;

public class Student extends BaseBankAccountOwner {

    private String school;
    public Student(String uuid, String firstName, String lastName, String school) {
        super(uuid, firstName, lastName);
        this.school = school;
    }

    public String getSchool() {
        return school;
    }
}
