package com.spa.spa.users.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "users")
@NoArgsConstructor
@Data
public class User {
    @Id
    private String id;

    private String fullName;

    private String username;

    private String password;

    private String phoneNumber;

    private String email;

    private String address;

    private String role;

    private boolean active;

}
