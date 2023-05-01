package com.example.authorization_service.domain;

import com.example.authorization_service.service.Authorities;

import java.util.ArrayList;
import java.util.List;

public class UserAuthority {
    
    private String login;
    private String password;
    private List<Authorities> auth;
    
    public UserAuthority() {
    }
    
    public UserAuthority(String login, String password) {
        this.login = login;
        this.password = password;
        this.auth = new ArrayList<>();
    }
    
    public String getLogin() { return login; }
    
    public String getPassword() { return password; }
    
    public List<Authorities> getAuth() { return auth; }
    
    public void setLogin(String login) { this.login = login; }
    
    public void setPassword(String password) { this.password = password; }
    
    public void setAuth(List<Authorities> auth) { this.auth = auth; }
}
