package edu.mum.accountservice.repository;

import edu.mum.accountservice.model.Account;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends CrudRepository<Account, Long> {

    Account findByEmailAndPassword(String email, String password);
}
