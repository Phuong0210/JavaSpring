package com.spa.spa.users.services;


import com.spa.spa.users.models.User;
import com.spa.spa.users.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public User findById(String userId){
        return userRepository.findById(userId).orElse(null);
    }
    @Override
    public User updateUser(User userDetails){
        return userRepository.save(userDetails);
    }

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }
    public User findUserByUsernameAndPassword(String username, String password){
        return userRepository.findUserByUsernameAndPassword(username, password);
    }
    @Override
    public User findByUsername(String username){
        return userRepository.findByUsername(username);
    };

    @Override
    public List<User> findAllByRole(String role){
        return userRepository.findAllByRole(role);
    }

}
