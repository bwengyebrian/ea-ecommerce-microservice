package edu.mum.shippingservice.controller;

import edu.mum.shippingservice.model.ItemToShip;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
public class ShippingController {

    @PostMapping("/ship")
    public String initiateShipping(@RequestBody ItemToShip itemToShip){
        //save the order and shipping address

        return "Your order will be shipped on: " + LocalDate.now().plusDays(1).toString();
    }

    @GetMapping("/ship")
    public String initiateShipping(){

        return "Your order will be shipped on: " + LocalDate.now().plusDays(1).toString();
    }


}
