package edu.mum.orderservice.serviceImpl;

import edu.mum.orderservice.model.User;
import edu.mum.orderservice.repository.UserRepository;
import edu.mum.orderservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
