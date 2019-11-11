package edu.mum.shippingservice.model;

import lombok.Data;

@Data
public class ItemToShip {
    private Order order;
    private Address address;
}
