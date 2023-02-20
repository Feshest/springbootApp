package ru.shestakov.springbootApp.dao;

import ru.shestakov.springbootApp.model.User;

import java.util.List;

public interface UserDAO {
    List<User> getAllUsers();
    User getUserById(Long id);
    void saveUser(User user);
    User updateUser(User user);
    void deleteUser(Long id);

}
