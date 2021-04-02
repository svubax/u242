package ru.web.dao;

import org.springframework.stereotype.Repository;
import ru.web.model.User;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {
    @PersistenceContext
    private EntityManager em;
    @Override
    public List<User> getUsers() {
        return em.createQuery("select e from User e", User.class)
                .getResultList();
    }
    @Override
    public void addUser(User user) {
        em.persist(user);
    }
    @Override
    public void updateUser(User user) {
        em.merge(user);
    }
    @Override
    public void deleteUser(int id) {
        em.createQuery("delete from User e where e.id = :id")
                .setParameter("id", id).executeUpdate();
    }
    @Override
    public User getUser(int id) {
        return em.createQuery("select e from User e where e.id = :id", User.class)
                .setParameter("id", id).getSingleResult();
    }
    @Override
    public User getUser(String username) {
        return em.createQuery("select e from User e where e.username = :username", User.class)
                .setParameter("username", username).getSingleResult();
    }
}
