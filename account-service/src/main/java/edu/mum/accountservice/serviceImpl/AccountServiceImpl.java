package edu.mum.accountservice.serviceImpl;

import edu.mum.accountservice.model.Account;
import edu.mum.accountservice.repository.AccountRepository;
import edu.mum.accountservice.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountRepository accountRepository;

    @Override
    public Account saveAccount(Account account) {
        return accountRepository.save(account);
    }

    @Override
    public Account getAccountById(long id) {
        return accountRepository.findById(id).get();
    }

    @Override
    public List<Account> getAccounts() {
        return (List<Account>) accountRepository.findAll();
    }
}
