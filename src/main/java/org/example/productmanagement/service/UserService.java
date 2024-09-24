package org.example.productmanagement.service;

import org.example.productmanagement.domain.User;
import org.example.productmanagement.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User handleCreateUser(User user) {
        return userRepository.save(user);
    }

    public void handleDeleteUser(long id) {
        userRepository.deleteById(id);
    }

    public User handleFetchUserById(long id) {
        return userRepository.findById(id).orElse(null);
    }

    public List<User> handlefetchAllUser(){
        return userRepository.findAll();
    }

    public User handleUpdateUser(User user) {
        User currentUser = this.userRepository.findById(user.getId()).orElse(null);
        if (currentUser != null){
            if (user.getName() != null){
                currentUser.setName(user.getName());
            }
            if (user.getEmail() != null){
                currentUser.setEmail(user.getEmail());
            }
            if (user.getPassword() != null){
                currentUser.setPassword(user.getPassword());
            }
            return this.userRepository.save(currentUser);
        }
        return currentUser;
    }
}
