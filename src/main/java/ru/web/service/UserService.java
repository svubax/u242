package ru.web.service;

import ru.web.model.User;

import java.util.List;

public interface UserService {
    List<User> getUsers();
    void addUser(User user);
    void updateUser(User user);
    void deleteUser(int id);
    User getUser(int id);
    User getUser(String username);
}
