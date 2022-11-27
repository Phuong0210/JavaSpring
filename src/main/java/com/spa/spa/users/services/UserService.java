package com.spa.spa.users.services;

import com.spa.spa.users.models.User;

import java.util.List;

public interface UserService {
    User findById(String userId);

    User updateUser(User userDetails);

    User createUser(User user);
    User findUserByUsernameAndPassword(String username, String password);

    User findByUsername(String username);

    List<User> findAllByRole(String role);
}
