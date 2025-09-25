package org.example.bankAccounts;

import org.example.people.BaseBankAccountOwner;


public class StudentBankAccount extends BaseBankAccount{

    private String school;

    public StudentBankAccount(String uuid, String accountNumber, BaseBankAccountOwner owner, double balance) {
        super(uuid, accountNumber, owner, balance);
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) { this.school = school; }
}
