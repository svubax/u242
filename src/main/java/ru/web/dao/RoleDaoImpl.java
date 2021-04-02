package ru.web.dao;

import org.springframework.stereotype.Repository;
import ru.web.model.Role;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class RoleDaoImpl implements RoleDao{
    @PersistenceContext
    private EntityManager em;
    @Override
    public List<Role> getRoles() {
        return em.createQuery("select e from Role e", Role.class).getResultList();
    }
    @Override
    public Role getRole(String nameRole) {
        return em.createQuery("select e from Role e where e.name=:name", Role.class)
                .setParameter("name", nameRole).getSingleResult();
    }
}
