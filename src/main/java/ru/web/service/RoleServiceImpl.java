package ru.web.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.web.dao.RoleDao;
import ru.web.model.Role;

import java.util.List;

@Service
@Transactional
public class RoleServiceImpl implements RoleService {
    private final RoleDao roleDao;
    public RoleServiceImpl(RoleDao roleDao) {
        this.roleDao = roleDao;
    }
    @Override
    public List<Role> getRoles() {
        return roleDao.getRoles();
    }
    @Override
    public Role getRole(String nameRole) {
        return roleDao.getRole(nameRole);
    }
}
