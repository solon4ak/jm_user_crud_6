package ru.solon4ak.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.solon4ak.model.Role;
import ru.solon4ak.model.User;
import ru.solon4ak.repository.UserDAO;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final UserDAO userDAO;

    public UserServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> listUsers() {
        return userDAO.getAll();
    }

    @Override
    public User save(User user) {
        return userDAO.save(user);
    }

    @Override
    @Transactional(readOnly = true)
    public User findUser(long id) {
        return userDAO.get(id);
    }

    @Override
    @Transactional(readOnly = true)
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
