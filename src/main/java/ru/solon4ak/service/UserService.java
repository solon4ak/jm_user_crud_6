package ru.solon4ak.service;

import ru.solon4ak.model.User;

import java.util.List;

public interface UserService {

    List<User> listUsers();
    User save(User user);
    User findUser(long id);
    User findByName(String nickName);
    User deleteUser(User user);
    String[] getUserRoles(User user);
}
