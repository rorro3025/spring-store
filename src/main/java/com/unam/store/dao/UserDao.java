package com.unam.store.dao;

import com.unam.store.models.User;

import java.util.List;

public interface UserDao {

    List<User> getUsers();

    void deleteUser(long id);

    void registerUser(User user);

    User getUserByCredentials(User user);
}
