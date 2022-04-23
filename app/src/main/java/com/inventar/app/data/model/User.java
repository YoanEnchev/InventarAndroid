package com.inventar.app.data.model;

public class User {

    private int id;
    private String username;
    private String[] roles;

    public User(int  id, String username, String[] roles) {
        this.id = id;
        this.username = username;
        this.roles = roles;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String[] getRoles() {
        return roles;
    }
}