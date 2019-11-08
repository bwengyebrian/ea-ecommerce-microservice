package edu.mum.orderservice.service;

import edu.mum.orderservice.model.Order;
import edu.mum.orderservice.model.User;

import java.util.List;

public interface OrderService {

    Order saveOrder(Order order);
    List<Order> getAllOrders();
    Order getAnOrder(long id);
    Order getCart(User user, Boolean orderCompleted);
}
