package org.example.bankAccounts;

import org.example.people.BaseBankAccountOwner;


public class StudentBankAccount extends BaseBankAccount{

    private String school;

    public StudentBankAccount(String uuid, String accountNumber, BaseBankAccountOwner owner, double balance, String school) {
        super(uuid, accountNumber, owner, balance);
        this.school = school;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) { this.school = school; }
}
