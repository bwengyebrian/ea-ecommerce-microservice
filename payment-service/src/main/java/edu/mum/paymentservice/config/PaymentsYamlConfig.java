package edu.mum.paymentservice.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;

@Configuration
@EnableConfigurationProperties
@ConfigurationProperties("payment")
public class PaymentsYamlConfig{

    private HashMap<String, String> paymentMethods;

    public PaymentsYamlConfig() {
    }

    public HashMap<String, String> getPaymentMethods() {
        return paymentMethods;
    }

    public void setPaymentMethods(HashMap<String, String> paymentMethods) {
        this.paymentMethods = paymentMethods;
    }

    @Override
    public String toString() {
        return "PaymentsYamlConfig{" +
                "paymentMethods=" + paymentMethods +
                '}';
    }
}