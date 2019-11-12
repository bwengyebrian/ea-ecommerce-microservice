package edu.mum.orderservice.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@FeignClient(value= "ea-ecommerce-paymentservice",url = "http://temp")
public interface PaymentMethodFeignClient {

    @PostMapping("/payment/methods/make/{key}")
    public String makePayment(URI url, @PathVariable String key, @RequestBody String reqApiKey);
}
