package edu.mum.orderservice.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "ea-ecommerce-paymentservice")
public interface PaymentMethodFeignClient {

    @GetMapping("/payment/type")
    public String paymentType();

    @GetMapping("/payment/made")
    public String paymentMade();

    @RequestMapping("/payment/methods/make/{key}")
    String makePayment(@PathVariable String key);
}
