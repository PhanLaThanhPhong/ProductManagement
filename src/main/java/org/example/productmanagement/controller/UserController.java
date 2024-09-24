package org.example.productmanagement.controller;

import org.example.productmanagement.domain.User;
import org.example.productmanagement.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // Create User
    @PostMapping("/user")
    public User createUser(@RequestBody User newUser){
        return this.userService.handleCreateUser(newUser);
    }

    // Read User
    @GetMapping("/user/{id}")
    public User getUser(@PathVariable long id){
        return this.userService.handleFetchUserById(id);
    }
    @GetMapping("/user")
    public List<User> getAllUsers(){
        return this.userService.handlefetchAllUser();
    }

    // Update User
    @PutMapping("/user")
    public User updateUser( @RequestBody User updatedUser){
        return this.userService.handleUpdateUser(updatedUser);
    }

    // Delete User
    @DeleteMapping("/user/{id}")
    public String deleteUser(@PathVariable("id") long id){
        this.userService.handleDeleteUser(id);
        return "User Id: " + id + " deleted";
    }
}
