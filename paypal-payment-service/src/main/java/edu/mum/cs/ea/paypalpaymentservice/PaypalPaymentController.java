package edu.mum.cs.ea.paypalpaymentservice;

import edu.mum.cs.ea.paypalpaymentservice.dto.PaymentResponse;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaypalPaymentController {

    @RequestMapping("paypal/makepayment")
    PaymentResponse makePayment(){
        PaymentResponse res = new PaymentResponse(true,"Payment made successfully with Paypal");
        System.out.println("payment made successfully with Paypal");
        return res;
    }
}
