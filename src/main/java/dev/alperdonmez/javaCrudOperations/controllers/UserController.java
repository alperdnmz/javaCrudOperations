package dev.alperdonmez.javaCrudOperations.controllers;

import dev.alperdonmez.javaCrudOperations.model.User;
import dev.alperdonmez.javaCrudOperations.services.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getUsers() {
        return userService.getUsers();
    }

    @PostMapping
    public User createUser(User user) {
        return userService.saveUser(user);
    }

    @GetMapping("/{user_id}")
    public User getOneUser(@PathVariable int user_id) {
        return userService.getUser(user_id);
    }

    @PutMapping("/{user_id}")
    public User updateUser(@PathVariable int user_id, @RequestBody User newUser) {
        return userService.updateUser(user_id, newUser);
    }

    @DeleteMapping("/{user_id}")
    public void deleteUser(@PathVariable int user_id) {
        userService.deleteUser(user_id);
    }
}
