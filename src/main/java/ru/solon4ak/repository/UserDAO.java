package ru.solon4ak.repository;

import ru.solon4ak.model.User;

import java.util.List;

public interface UserDAO {
    List<User> getAll();
    User save(User user);
    User get(long id);
    User getByUsername(String nickName);
    User delete(User user);
}
