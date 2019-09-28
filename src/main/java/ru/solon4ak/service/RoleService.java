package ru.solon4ak.service;

import ru.solon4ak.model.Role;

import java.util.List;

public interface RoleService {

    List<Role> getAllRoles();
    List<String> getAllRolesNames();
    Role addNewRole(Role role);
    Role deleteRole(Role role);
    Role getRoleByName(String roleName);
}
