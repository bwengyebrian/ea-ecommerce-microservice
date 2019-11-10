package edu.mum.orderservice.feign;

import edu.mum.orderservice.model.ItemToShip;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@FeignClient(name = "ea-ecommerce-shippingservice")
public interface ShippingFeignClient {

    @PostMapping("/ship")
    public String initiateShipping(@RequestBody ItemToShip itemToShip);

    @GetMapping("/ship")
    public String initiateShipping();
}
