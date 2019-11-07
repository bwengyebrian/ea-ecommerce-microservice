package edu.mum.orderservice.service;

import edu.mum.orderservice.model.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    User saveUser(User user);

    User getUserByUsername(String username);
}
