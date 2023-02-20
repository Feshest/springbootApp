package ru.shestakov.springbootApp.dao;

import org.springframework.stereotype.Repository;
import ru.shestakov.springbootApp.model.User;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class UserDAOImp implements UserDAO{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> getAllUsers() {
        String hql = "from User";
        Query query = entityManager.createQuery(hql, User.class);
        List<User> usersList = query.getResultList();
        return usersList;
    }

    @Override
    public User getUserById(Long id) {
        return entityManager.createQuery(
                "select u from User u where u.id = :id", User.class)
                .setParameter("id", id)
                .getResultList().stream().findAny().orElse(null);
    }

    @Override
    public void saveUser(User user) {
        entityManager.persist(user);

    }

    @Override
    public User updateUser(User user) {
        return entityManager.merge(user);
    }

    @Override
    public void deleteUser(Long id) {
        entityManager.createQuery(
                "delete from User where id = :id")
                .setParameter("id", id)
                .executeUpdate();
    }
}
