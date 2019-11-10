package edu.mum.accountservice.repository.InitialData;

import edu.mum.accountservice.model.Account;
import edu.mum.accountservice.model.Address;
import edu.mum.accountservice.repository.AccountRepository;
import edu.mum.accountservice.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class AccountLoader implements CommandLineRunner {
    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private AccountRepository accountRepository;

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
        account1.setFirstName("abebe");
        account1.setLastName("beso");
        account1.setAddress(address1);
        accountRepository.save(account1);

        Account account2 = new Account();
        Address address2 = new Address();
        address2.setCity("Kampala");
        address2.setState("Uganda");
        address2.setStreet("Matugga–Kapeeka Road");
        address2.setZip("1235");
        addressRepository.save(address2);
        account2.setEmail("namazzi@abebe.com");
        account2.setFirstName("Namazzi");
        account2.setLastName("Abbo");
        account2.setAddress(address2);
        accountRepository.save(account2);

    }
}
