package ru.web.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import ru.web.model.User;

import java.util.List;

public interface UserService extends UserDetailsService {
    List<User> getUsers();
    void addUser(User user);
    void updateUser(User user);
    void deleteUser(int id);
    User getUser(int id);
    User getUser(String username);
}
