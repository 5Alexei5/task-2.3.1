package ru.tereshin.springmvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.tereshin.springmvc.dao.UserDAO;
import ru.tereshin.springmvc.model.User;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;


    @Override
    public List<User> getAllUsers() {
        return userDAO.allUsers();
    }

    @Override
    public void addUser(User user) {
        userDAO.addUser(user);
    }

    @Override
    public void update(User user, long id) {
        userDAO.update(user, id);
    }

    @Override
    public User getUser(long id) {
        return userDAO.getUser(id);
    }

    @Override
    public void deleteUser(long id) {
        userDAO.deleteUser(id);
    }
}
