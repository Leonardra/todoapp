package com.todo.app.todoapp.service;


import com.todo.app.todoapp.UpdateEmail;
import com.todo.app.todoapp.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    void addUser(User user);
    List<User> getUsers();
    void deleteUser(String email);
    void updateEmail(UpdateEmail update);

}
