package ru.web.service;

import ru.web.model.Role;

import java.util.List;

public interface RoleService {
    List<Role> getRoles();
    Role getRole(String nameRole);
}
