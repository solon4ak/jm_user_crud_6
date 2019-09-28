package ru.solon4ak.repository;

import ru.solon4ak.model.Role;

import java.util.List;

public interface RoleDAO {

    List<Role> getAll();
    Role add(Role role);
    Role delete(Role role);
    Role getByName(String roleName);
}
