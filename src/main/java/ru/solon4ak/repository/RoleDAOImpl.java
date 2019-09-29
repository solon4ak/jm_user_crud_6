package ru.solon4ak.repository;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ru.solon4ak.model.Role;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class RoleDAOImpl implements RoleDAO {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Role> getAll() {
        return entityManager.createQuery("select role from Role role").getResultList();
    }

    @Override
    public Role add(Role role) {
        entityManager.persist(role);
        return role;
    }

    @Override
    public Role getByName(String roleName) {
        String hql = "select role from Role role where role.name = :name";
        Query query = entityManager.createQuery(hql);
        query.setParameter("name", roleName);
        return (Role) query.getSingleResult();
    }

    @Override
    public Role delete(Role role) {
        entityManager.remove(role);
        return role;
    }
}
