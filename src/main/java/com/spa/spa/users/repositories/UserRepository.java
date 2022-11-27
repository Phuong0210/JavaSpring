package com.spa.spa.users.repositories;

import com.spa.spa.users.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends MongoRepository<User, String>{
    User findUserByUsernameAndPassword(String username, String password);

    User findByUsername(String username);

    List<User> findAllByRole(String role);
}
