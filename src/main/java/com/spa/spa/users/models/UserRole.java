package com.spa.spa.users.models;

public enum UserRole {
    CLIENT("client"),
    MASSAGER("massager"),
    PROVIDER("provider");

    public String getName() {
        return name;
    }

    private final String name;
    UserRole(String name){
        this.name=name;
    }
}
