package com.example.appunpar;

public class loginInput {
    private String email;
    private String password;
    private String role;

    public loginInput(String email, String pass,String role){
        this.email = email;
        this.password = pass;
        this.role= role;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getRole() {
        return role;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public void setRole(String role) {
        this.role = role;
    }
}
