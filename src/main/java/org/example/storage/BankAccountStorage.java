package org.example.storage;

import com.google.inject.Singleton;
import org.example.bankAccounts.BaseBankAccount;

import java.util.HashMap;
import java.util.Map;

@Singleton
public class BankAccountStorage {
    protected Map<String, BaseBankAccount> bankAccountsMap;

    public BankAccountStorage() {
        this.bankAccountsMap = new HashMap<>();
    }
    public void addBankAccount(BaseBankAccount bankAccount){
        this.bankAccountsMap.put(bankAccount.getUuid(), bankAccount);
    }

    public Map<String, BaseBankAccount> getBankAccountsMap() { return new HashMap<>(this.bankAccountsMap); }
}
