package ru.solon4ak.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.solon4ak.model.Role;
import ru.solon4ak.model.User;
import ru.solon4ak.repository.UserDAO;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDAO userDAO;

    @Override
    public List<User> listUsers() {
        return userDAO.getAll();
    }

    @Override
    public User save(User user) {
        return userDAO.save(user);
    }

    @Override
    public User findUser(long id) {
        return userDAO.get(id);
    }

    @Override
    public User findByName(String nickName) {
        return userDAO.getByUsername(nickName);
    }

    @Override
    public User deleteUser(User user) {
        return userDAO.delete(user);
    }

    @Override
    public String[] getUserRoles(User user) {
        String[] roles = new String[user.getRoles().size()];
        int i = 0;
        for (Role role : user.getRoles()) {
            roles[i] = role.getName();
            i++;
        }
        return roles;
    }
}
