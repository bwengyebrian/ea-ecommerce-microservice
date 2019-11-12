package edu.mum.orderservice.feign;

import edu.mum.orderservice.model.Account;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@FeignClient(value = "ea-ecommerce-accountservice",url = "http://temp")
public interface AccountFeignClient {


//    @PostMapping("/account/add")
//    public Account createAccount(@RequestBody Account account);

    //@GetMapping("account/get/{accountId}")
    @PostMapping("/authenticate")
    public Account getAccount(URI url , @RequestBody String authorizationToken, @PathVariable("accountId") int accountId);

//    @GetMapping("/account/all")
//    public List<Account> getAllAccounts();
}
