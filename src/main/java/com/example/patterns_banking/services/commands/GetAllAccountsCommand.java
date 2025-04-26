package com.example.patterns_banking.services.commands;

import com.example.patterns_banking.models.Account;
import com.example.patterns_banking.repositories.IAccountRepository;

import java.util.List;

public class GetAllAccountsCommand implements  ICommand<List<Account>> {

    private final IAccountRepository accountRepository;

    public GetAllAccountsCommand(IAccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public List<Account> execute() {

        List<Account> accounts = accountRepository.findAll();

        if (accounts.isEmpty()) {
            throw new RuntimeException("No accounts found");
        }

        return accounts;
    }
}
