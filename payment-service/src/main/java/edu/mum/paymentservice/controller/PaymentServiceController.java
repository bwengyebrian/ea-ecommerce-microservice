package edu.mum.paymentservice.controller;

import edu.mum.paymentservice.config.PaymentsYamlConfig;
import edu.mum.paymentservice.dto.Order;
import edu.mum.paymentservice.dto.PaymentDetails;
import edu.mum.paymentservice.feign.PaymentServiceFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.Map;
import java.util.Set;

@RestController
@RefreshScope
public class PaymentServiceController {
    @Autowired
    PaymentsYamlConfig payments;

    @Autowired
    PaymentServiceFeign paymentServiceFeign;

    @RequestMapping("/payment/methods")
    Set<String> paymentMethods(){
        return  payments.getPaymentMethods().keySet();
    }

    @RequestMapping("/payment/methods/{key}")
    String paymentMethodByKey(@PathVariable String key){
          return  payments.getPaymentMethods().get( key);
    }

    @RequestMapping("/payment/methods/make/{key}")
       public String makePayment(@PathVariable String key){
        String paymentService = payments.getPaymentMethods().get(key);
        URI newUri = URI.create(paymentService);
        PaymentDetails paymentDetails = new PaymentDetails();
//        paymentDetails.setUserId(order.getUser().getId());
//        paymentDetails.setFirstName(order.getUser().getFirstName());
//        paymentDetails.setLastName(order.getUser().getLastName());
//        paymentDetails.setPaymentAmount(order.getTotalAmount());
//        paymentDetails.setPaymentFor("Order Id : " + order.getId() );
          String response = paymentServiceFeign.makePayment(newUri);
        return response;
    }

}
