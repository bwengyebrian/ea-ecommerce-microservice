package edu.mum.accountservice.repository.InitialData;

import edu.mum.accountservice.model.Account;
import edu.mum.accountservice.model.Address;
import edu.mum.accountservice.repository.AccountRepository;
import edu.mum.accountservice.repository.AddressRepository;
import edu.mum.accountservice.service.AccountService;
import edu.mum.accountservice.serviceImpl.AccountServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class AccountLoader implements CommandLineRunner {
    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private AccountServiceImpl accountService;

    @Override
    public void run(String... args) throws Exception {
        loadInitialAccounts();
    }

    public void loadInitialAccounts(){
        Account account1 = new Account();
        Address address1 = new Address();
        address1.setCity("Addis Ababa");
        address1.setState("Ethiopia");
        address1.setStreet("Piassa");
        address1.setZip("1234");
        addressRepository.save(address1);
        account1.setEmail("abebe@abebe.com");
        account1.setPassword("1234");
        account1.setFirstName("abebe");
        account1.setLastName("beso");
        account1.setAddress(address1);
        account1.setUsername("user");
        account1.setPassword("user");
        accountService.saveAccount(account1);

        Account account2 = new Account();
        Address address2 = new Address();
        address2.setCity("Kampala");
        address2.setState("Uganda");
        address2.setStreet("Matugga–Kapeeka Road");
        address2.setZip("1235");
        addressRepository.save(address2);
        account2.setEmail("namazzi@abebe.com");
        account2.setPassword("1234");
        account2.setFirstName("Namazzi");
        account2.setLastName("Abbo");
        account2.setAddress(address2);
        account2.setUsername("admin");
        account2.setPassword("admin");
       accountService.saveAccount(account2);

    }
}
