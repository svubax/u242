package ru.web.dao;

import ru.web.model.User;

import java.util.List;

public interface UserDao {
    List<User> getUsers();
    void addUser(User user);
    void updateUser(User user);
    void deleteUser(int id);
    User getUser(int id);
    User getUser(String username);
}
