package com.example.appunpar;

public class loginInput {
    private String username;
    private String password;

    public loginInput(String username, String pass){
        this.username = username;
        this.password = pass;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
