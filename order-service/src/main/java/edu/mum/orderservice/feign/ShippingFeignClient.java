package edu.mum.orderservice.feign;

import edu.mum.orderservice.model.ItemToShip;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.net.URI;


@FeignClient(value = "ea-ecommerce-shippingservice",url = "http://temp")
public interface ShippingFeignClient {

    @PostMapping("/ship")
    public String initiateShipping(URI url, @RequestBody ItemToShip itemToShip);

    @GetMapping("/ship")
    public String initiateShipping(URI url);
}
