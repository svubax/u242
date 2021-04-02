package ru.web.service;

import org.springframework.stereotype.Service;
import ru.web.dao.UserDao;
import ru.web.model.User;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    private final UserDao userDao;
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }
    @Override
    public List<User> getUsers(){
        return userDao.getUsers();
    }
    @Override
    public void addUser(User user){
        userDao.addUser(user);
    }
    @Override
    public void deleteUser(int id) {
        userDao.deleteUser(id);
    }
    @Override
    public void updateUser(User user) {
        userDao.updateUser(user);
    }
    @Override
    public User getUser(int id) {
        return userDao.getUser(id);
    }
    @Override
    public User getUser(String username) {
        return userDao.getUser(username);
    }
}
