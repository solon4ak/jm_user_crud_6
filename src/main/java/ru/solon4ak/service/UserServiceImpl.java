package ru.solon4ak.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.solon4ak.model.User;
import ru.solon4ak.repository.UserDAO;

import java.util.List;

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
}
