package org.example.productmanagement.service;

import org.example.productmanagement.domain.User;
import org.example.productmanagement.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User handleCreateUser(User user) {
        return userRepository.save(user);
    }
}
