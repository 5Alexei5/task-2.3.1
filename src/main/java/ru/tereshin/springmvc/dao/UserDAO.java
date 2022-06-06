package ru.tereshin.springmvc.dao;

import ru.tereshin.springmvc.model.User;

import java.util.List;

public interface UserDAO {

    List<User> allUsers();

    void addUser(User user);

    void update(User user, long id);

    void deleteUser(long id);

    User getUser(long id);
}
