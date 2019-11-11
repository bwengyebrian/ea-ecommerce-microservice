package edu.mum.accountservice.controller;

import edu.mum.accountservice.model.Account;
import edu.mum.accountservice.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @PostMapping("/create")
    public Account createAccount(@RequestBody Account account){

        return accountService.saveAccount(account);
    }

    @GetMapping("/get/{accountId}")
    public Account getAccount(@PathVariable("accountId") int accountId){
        Account account = accountService.getAccountById(accountId);
        return account;
    }

    @GetMapping("/all")
    public List<Account> getAllAccounts(){
        return accountService.getAccounts();
    }
}
