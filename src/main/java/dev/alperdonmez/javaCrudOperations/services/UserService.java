package dev.alperdonmez.javaCrudOperations.services;

import dev.alperdonmez.javaCrudOperations.model.User;
import dev.alperdonmez.javaCrudOperations.repository.IUserRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    IUserRepository userRepository;

    public UserService(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public User getUser(int user_id){
        return userRepository.findById(user_id).orElse(null);
    }

    public User saveUser(User newUser){
        return userRepository.save(newUser);
    }

    public User updateUser(@PathVariable int user_id, @RequestBody User newUser){
        Optional<User> user = userRepository.findById(user_id);
        if(user.isPresent()){
            User getUser = user.get();
            getUser.setUsername(newUser.getUsername());
            getUser.setPassword(newUser.getPassword());
            userRepository.save(getUser);
            return getUser;
        }
        else{
            return null;
        }
    }

    public void deleteUser(int user_id){
        userRepository.deleteById(user_id);
    }
}
