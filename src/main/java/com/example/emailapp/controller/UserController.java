package com.example.emailapp.controller;

import com.example.emailapp.model.Mail;
import com.example.emailapp.model.User;
import com.example.emailapp.repo.UserRepository;
import com.example.emailapp.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class UserController {

    private final UserRepository userRepository;
    private final UserService userService;

    @PostMapping("/register")
    public void registerUser(@RequestBody User user){
        userService.registerNewUser(user);
    }

    @PostMapping("/login")
    public ResponseEntity<User> loginUser(@RequestBody User user){
        User user1 = userService.loginUser(user);
        return new ResponseEntity<>(user1, HttpStatus.OK);
    }

    @DeleteMapping("/{email}/logout")
    public void logoutUser(@PathVariable String email){
        userService.logoutUser(email);
    }

    @GetMapping("/{email}/inbox")
    public List<Mail> getInbox(@PathVariable String email){
        return userService.getInbox(email);
    }

    @GetMapping("/{email}/sent")
    public List<Mail> getSent(@PathVariable String email){
        return userService.getSent(email);
    }


}
