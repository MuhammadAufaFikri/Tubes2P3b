package com.example.appunpar;

import java.util.List;

public class saveToken {
    private static String id;
    private static String name;
    private static String email;
    private static String token;

    public saveToken(String id,String name,String email,String token) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.token = token;
    }

    public static String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public static String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public static String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
