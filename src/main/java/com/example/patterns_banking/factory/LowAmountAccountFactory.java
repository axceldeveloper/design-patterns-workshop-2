package com.example.patterns_banking.factory;

import com.example.patterns_banking.models.Account;
import com.example.patterns_banking.models.Customer;
import com.example.patterns_banking.models.LowAmountAccount;
import com.example.patterns_banking.factory.AccountFactoryProvider.AccountType;
import org.springframework.stereotype.Component;

@Component
public class LowAmountAccountFactory implements AccountFactory{

    @Override
    public Account createAccount(Customer customer, String accountNumber, Double balance, AccountType accountType) {
        LowAmountAccount account = new LowAmountAccount();
        account.setAccountNumber(accountNumber);
        account.setBalance(balance);
        account.setAccountType(accountType);
        account.setCustomer(customer);
        return account;
    }
}
