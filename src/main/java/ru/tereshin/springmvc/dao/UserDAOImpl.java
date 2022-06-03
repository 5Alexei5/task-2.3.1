package ru.tereshin.springmvc.dao;

import org.springframework.stereotype.Repository;
import ru.tereshin.springmvc.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> allUsers() {
        return entityManager.createQuery("from User", User.class).getResultList();
    }

    @Override
    public void addUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public void update(User user, long id) {
        User userForUpdate = getUser(id);
        entityManager.detach(userForUpdate);
        userForUpdate.setName(user.getName());
        userForUpdate.setSurName(user.getSurName());
        userForUpdate.setAge(user.getAge());

        entityManager.merge(userForUpdate);
    }

    @Override
    public User getUser(long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public void deleteUser(long id) {
        User user = getUser(id);
        entityManager.remove(user);
    }
}
