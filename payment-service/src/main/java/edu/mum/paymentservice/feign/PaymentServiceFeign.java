package edu.mum.paymentservice.feign;

import edu.mum.paymentservice.dto.PaymentDetails;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.net.URI;

@FeignClient(value = "payment",url = "http://localhost:8080/paymentsx")
public interface PaymentServiceFeign {
    @RequestMapping(path = "/makepayment")
    String makePayment(URI baseUrl);
}
