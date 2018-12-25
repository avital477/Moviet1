package com.example.user.moviet;

public class User {

    private String email;
    private String password;

    public User() { }

    public User(String email, String password, String name, String lastName) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
