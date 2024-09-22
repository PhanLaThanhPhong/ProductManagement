package org.example.productmanagement.controller;

import org.example.productmanagement.domain.User;
import org.example.productmanagement.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("user/create")
    public String createUser(){
        User user = new User();
        user.setName("Phong");
        user.setEmail("phong@gmail.com");
        user.setPassword("123456");
        this.userService.handleCreateUser(user);

        return "User created";
    }
}
