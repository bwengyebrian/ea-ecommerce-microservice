package edu.mum.orderservice.feign;

import edu.mum.orderservice.model.Account;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "ea-ecommerce-accountservice")
public interface AccountFeignClient {


//    @PostMapping("/account/add")
//    public Account createAccount(@RequestBody Account account);

    @GetMapping("/account/get/{accountId}")
    public Account getAccount(@PathVariable("accountId") int accountId);

//    @GetMapping("/account/all")
//    public List<Account> getAllAccounts();
}
