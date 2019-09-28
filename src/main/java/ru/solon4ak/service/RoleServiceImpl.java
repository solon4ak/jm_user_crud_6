package ru.solon4ak.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.solon4ak.model.Role;
import ru.solon4ak.repository.RoleDAO;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDAO roleDAO;

    @Override
    public List<Role> getAllRoles() {
        return roleDAO.getAll();
    }

    @Override
    public List<String> getAllRolesNames() {
        List<String> roleNames = new ArrayList<>();
        for (Role role :
                this.getAllRoles()) {
            roleNames.add(role.getName());
        }
        return roleNames;
    }

    @Override
    public Role addNewRole(Role role) {
        return roleDAO.add(role);
    }

    @Override
    public Role deleteRole(Role role) {
        return roleDAO.delete(role);
    }

    @Override
    public Role getRoleByName(String roleName) {
        return roleDAO.getByName(roleName);
    }
}
