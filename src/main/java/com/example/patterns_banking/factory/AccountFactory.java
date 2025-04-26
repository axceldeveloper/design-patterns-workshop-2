package com.example.patterns_banking.factory;

import com.example.patterns_banking.models.Account;
import com.example.patterns_banking.models.Customer;
import com.example.patterns_banking.factory.AccountFactoryProvider.AccountType;

public interface AccountFactory {
  Account createAccount(Customer customer, String accountNumber, Double balance,
                        AccountType accountType);
}
