package io.changerman.springbootpatterns.controller;

import io.changerman.springbootpatterns.model.User;
import io.changerman.springbootpatterns.repository.UserRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @GetMapping
    public ResponseEntity<List<User>> getAllUser(){
        return new ResponseEntity<>(userRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<User> getUserById (@PathVariable("userId") long userId) throws Exception {
        return new ResponseEntity<>(userRepository.findById(userId), HttpStatus.OK);
    }

    @PutMapping("/{userId}")
    public ResponseEntity<User> updateUser (@PathVariable("userId") long userId, @RequestBody User user) throws Exception {
        User userToUpdate = userRepository.findById(userId);
        userToUpdate.setName(user.getName());
        userToUpdate.setLastName(user.getLastName());
        userToUpdate.setAge(user.getAge());

        userRepository.save(userToUpdate);

        return new ResponseEntity<>(userToUpdate, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<User> saveUser(@NotNull @RequestBody User user) {
        userRepository.save(user);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<Boolean> deleteUser (@PathVariable("userId") long userId){
        userRepository.delete(userRepository.findById(userId));
        return new ResponseEntity<>(Boolean.TRUE, HttpStatus.OK);
    }

}
