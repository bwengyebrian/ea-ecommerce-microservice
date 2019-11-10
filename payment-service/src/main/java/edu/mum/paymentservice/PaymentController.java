package edu.mum.paymentservice;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {

    @GetMapping("/payment/type")
    public String paymentType(){
        return "Successfully selected payment type: ";
    }
    @GetMapping("/payment/made")
    public String paymentMade(){
        return "Successfully made the payment of : ";
    }

}
