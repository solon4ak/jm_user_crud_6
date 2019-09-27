package ru.solon4ak.repository;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.solon4ak.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
@Transactional
public class UserDAOImpl implements UserDAO {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    @Transactional(readOnly = true)
    public User get(long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    @Transactional(readOnly = true)
    public User getByUsername(String nickName) {
        String hql = "select u from User u where u.username = :name";
        Query query = entityManager.createQuery(hql);
        query.setParameter("name", nickName);
        return (User) query.getSingleResult();
    }

    @Override
    public User delete(User user) {
        entityManager.remove(user);
        return user;
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> getAll() {
        return entityManager.createQuery("select u from User u").getResultList();
    }

    @Override
    public User save(User user) {
        if (user.getId() == null) {
            entityManager.persist(user);
        } else {
            entityManager.merge(user);
        }
        return user;
    }
}
