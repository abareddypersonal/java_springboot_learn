package com.atchi.learningspringboot.controller;

import com.atchi.learningspringboot.model.User;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class HelloController {
    @GetMapping("/home")
    public String home(){
        return  "Hello, Welcome to my world!";
    }

    @GetMapping("/user")
    public User getUser(){
        return new User("ram");
    }

    @GetMapping("/allusers")
    public  List<User> getAllUser(){

        List<User> users = new ArrayList<>();

        users.add(new User("ram"));
        users.add(new User("ram"));
        return users;
    }
    @PostMapping("/createuserdummy")
    public String createUserDummy(){
        return "UserCreated";
    }

    @PostMapping("/createuser")
    public User createUser(@RequestBody User user){
        System.out.println(user.getUsername());
        return user;
    }

    @PutMapping("/users/{id}")
    public String updateUser(@PathVariable int id) {

        return "Updating user " + id;
    }

    @DeleteMapping("/users/{id}")
    public String deleteUser(@PathVariable int id) {

        return "Deleted user " + id;
    }
    @GetMapping("/users")
    public String searchUser(@RequestParam String name) {

        return "Searching for " + name;
    }



}
