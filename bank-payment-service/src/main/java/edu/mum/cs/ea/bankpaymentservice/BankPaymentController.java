package edu.mum.cs.ea.bankpaymentservice;

import edu.mum.cs.ea.bankpaymentservice.dto.PaymentResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BankPaymentController {

    @RequestMapping("bank/makepayment")
    PaymentResponse makePayment(){
        PaymentResponse res = new PaymentResponse(true,"Payment made successfully with Bank Debit");
        System.out.println("payment made successfully with Bank Debt");
        return res;
    }
}
