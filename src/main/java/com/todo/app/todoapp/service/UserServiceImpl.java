package com.todo.app.todoapp.service;

import com.todo.app.todoapp.UpdateEmail;
import com.todo.app.todoapp.User;
import com.todo.app.todoapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepository userDataBase;

    public void addUser(User user) {
        userDataBase.save(user);
    }


    public List<User> getUsers() {
        return userDataBase.findAll();
    }

    public User findUserByEmail(String email) {
        Optional<User> optionalNative = Optional.ofNullable(userDataBase.findUserByEmailAddress(email));
        if(optionalNative.isPresent()){
            return optionalNative.get();
        }
        throw new RuntimeException("Invalid email");
    }


    public void deleteUser(String email) {
        User user = findUserByEmail(email);
        userDataBase.delete(user);
    }

    public void updateEmail(UpdateEmail update) {
        User foundUser =findUserByEmail(update.getCurrentEmail());
        foundUser.setEmailAddress(update.getNewEmail());
        userDataBase.save(foundUser);
    }
}
