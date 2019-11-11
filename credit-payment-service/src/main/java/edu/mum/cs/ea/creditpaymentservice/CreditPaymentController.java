package edu.mum.cs.ea.creditpaymentservice;

import edu.mum.cs.ea.creditpaymentservice.dto.PaymentResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CreditPaymentController {

    @RequestMapping("credit/makepayment")
    public String makePayment(){
        PaymentResponse res = new PaymentResponse(true,"Payment made successfully with Credit Card");
        System.out.println("payment made successfully with Credit Card");
        return "Payment made successfully with Credit Card";
    }
}
