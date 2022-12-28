package com.example.appunpar;


public class loginResult {

    private String token;
    private String pesan;

    public loginResult(String token, String pesan){
        this.token = token;
        this.pesan = pesan;
    }

    public String getPesan() {
        return pesan;
    }

    public String getToken() {
        return token;
    }

    public void setPesan(String pesan) {
        this.pesan = pesan;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
