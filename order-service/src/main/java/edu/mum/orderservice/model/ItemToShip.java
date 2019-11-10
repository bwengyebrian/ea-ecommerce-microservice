package edu.mum.orderservice.model;

import lombok.Data;

@Data
public class ItemToShip {
    private Order order;
    private Address address;
}
