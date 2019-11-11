package edu.mum.accountservice.serviceImpl;

import edu.mum.accountservice.model.Account;
import edu.mum.accountservice.model.Address;
import edu.mum.accountservice.repository.AccountRepository;
import edu.mum.accountservice.repository.AddressRepository;
import edu.mum.accountservice.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Account saveAccount(Account account) {
        String password = account.getPassword();
        String hasshed = passwordEncoder.encode(password);
        System.out.println("hashed pashed account service : " + hasshed);
        account.setPassword(hasshed);
        Address address = new Address();
        address = account.getAddress();
//        System.out.println(address.getCity());
        addressRepository.save(address);
        account.setAddress(address);

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

    @Override
    public Account findUserByUsername(String username) {
        return accountRepository.findUserByUsername(username);
    }
}
