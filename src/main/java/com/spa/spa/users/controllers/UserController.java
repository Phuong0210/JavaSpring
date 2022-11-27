package com.spa.spa.users.controllers;

import com.spa.spa.users.models.User;
import com.spa.spa.users.models.UserRole;
import com.spa.spa.users.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin("http://localhost:8080")
@AllArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/users/{id}")
    public ResponseEntity<User> findById(@PathVariable(value = "id")String userId){
        User user = userService.findById(userId);
        if(user == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PostMapping("/users/register")
    public ResponseEntity<User> createUser(@RequestBody User user) {
         if (isValidUserName(user.getUsername())) {
             return new ResponseEntity<>(userService.createUser(user),HttpStatus.CREATED);
         }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    public boolean isValidUserName(String username) {
        User isExistUser = userService.findByUsername(username);

        if (isExistUser == null) {
            return true;
        }
        return  false;
    }

    @PostMapping("/users/login")
    public ResponseEntity<User> loginUser(@RequestPart String username,
                                          @RequestPart String password){

        User existedUser = userService.findUserByUsernameAndPassword(username, password);
        if (existedUser == null) {
            throw new IllegalStateException("username or password incorrect");
        }
        return new ResponseEntity<>(existedUser, HttpStatus.OK);
    }

    @GetMapping("/users/massagers")
    public ResponseEntity<List<User>> getAllMassagers() {
        List<User> allMassagers = userService.findAllByRole(UserRole.MASSAGER.getName());
        return new ResponseEntity<>(allMassagers, HttpStatus.OK);
    }

    @GetMapping("/users/providers")
    public ResponseEntity<List<User>> getAllProvider() {
        List<User> allProviders = userService.findAllByRole(UserRole.PROVIDER.getName());
        return new ResponseEntity<>(allProviders, HttpStatus.OK);
    }
}

