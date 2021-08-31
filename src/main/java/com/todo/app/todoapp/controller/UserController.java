package com.todo.app.todoapp.controller;



import com.todo.app.todoapp.UpdateEmail;
import com.todo.app.todoapp.User;
import com.todo.app.todoapp.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "")
public class UserController {

    @Autowired
    UserServiceImpl userServiceImpl;
    
    @PostMapping("/addUser")
    public void addUser(){
        User user = new User(1L, "Oluwatobi", "Jolayemi", "tobi@gmail.com", "123456");
        userServiceImpl.addUser(user);
    }

    @GetMapping
    public List<User> getUsers(){
        return userServiceImpl.getUsers();
    }

    @DeleteMapping("/deleteUser{email}")
    public void deleteUser(@PathVariable String email){
        userServiceImpl.deleteUser(email);
    }

    @PutMapping("/updateUser")
    public void updateUserEmail(UpdateEmail updateEmail){
        userServiceImpl.updateEmail(updateEmail);
    }
}
