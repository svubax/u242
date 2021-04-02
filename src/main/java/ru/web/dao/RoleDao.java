package ru.web.dao;

import ru.web.model.Role;

import java.util.List;

public interface RoleDao {
    List<Role> getRoles();
    Role getRole(String nameRole);
}
