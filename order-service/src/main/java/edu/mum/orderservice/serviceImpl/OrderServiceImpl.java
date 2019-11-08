package edu.mum.orderservice.serviceImpl;

import edu.mum.orderservice.model.Order;
import edu.mum.orderservice.model.User;
import edu.mum.orderservice.repository.OrderRepository;
import edu.mum.orderservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;
    @Override
    public Order saveOrder(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public List<Order> getAllOrders() {
        return (List<Order>)orderRepository.findAll();
    }

    @Override
    public Order getAnOrder(long id) {
        return orderRepository.findById(id).get();
    }

    @Override
    public Order getCart(User user, Boolean orderCompleted) {
        return orderRepository.findByUserAndOrderCompleteIsFalse(user, orderCompleted);
    }


}
