package edu.mum.accountservice.repository;

import edu.mum.accountservice.model.Account;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends CrudRepository<Account, Long> {
<<<<<<< HEAD
    Account findUserByUsername(String username);
=======

    Account findByEmailAndPassword(String email, String password);
>>>>>>> d68b3bad9376dabcddfb87286b295f1be313c87c
}
