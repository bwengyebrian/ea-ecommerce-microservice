package edu.mum.orderservice.service;

import edu.mum.orderservice.model.Order;

import java.util.List;

public interface OrderService {

    Order saveOrder(Order order);
    List<Order> getAllOrders();
    Order getAnOrder(long id);
    Order getCart(long id);
}
