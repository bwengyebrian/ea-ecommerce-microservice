package edu.mum.orderservice.repository;

import edu.mum.orderservice.model.Order;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends CrudRepository<Order, Long> {

//    Order findByUserAndOrderCompleteIsFalse(User user);
    Order findByUseridAndOrderCompleteIsFalse(long id);
}
