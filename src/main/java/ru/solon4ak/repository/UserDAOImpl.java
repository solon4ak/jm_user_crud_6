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
    EntityManager em;

    @Override
    @Transactional(readOnly = true)
    public User get(long id) {
        return em.find(User.class, id);
    }

    @Override
    @Transactional(readOnly = true)
    public User getByUsername(String nickName) {
        String hql = "select u from User u where u.username = :name";
        Query query = em.createQuery(hql);
        query.setParameter("name", nickName);
        return (User) query.getSingleResult();
    }

    @Override
    public User delete(User user) {
        em.remove(em.contains(user) ? user : em.merge(user));
        return user;
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> getAll() {
        return em.createQuery("select u from User u").getResultList();
    }

    @Override
    public User save(User user) {
        if (user.getId() == null) {
            em.persist(user);
        } else {
            em.merge(user);
        }
        return user;
    }
}
