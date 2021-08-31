package com.todo.app.todoapp.repository;
import com.todo.app.todoapp.UpdateEmail;
import com.todo.app.todoapp.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findUserByEmailAddress(String emailAddress);
}
