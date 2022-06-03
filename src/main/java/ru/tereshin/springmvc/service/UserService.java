package ru.tereshin.springmvc.service;

import ru.tereshin.springmvc.model.User;

import java.util.List;

public interface UserService {

    List<User> getAllUsers();

    void addUser(User user);

    void update(User user, long id);

    User getUser(long id);

    void deleteUser(long id);
}
