package edu.mum.accountservice.service;

import edu.mum.accountservice.model.Account;

import java.util.List;

public interface AccountService {

    Account saveAccount(Account account);
    Account getAccountById(long id);
    List<Account> getAccounts();
    Account getAccountByEmailAndPassword(String email, String password);
}
