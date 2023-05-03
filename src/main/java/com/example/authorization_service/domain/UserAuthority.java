package com.example.authorization_service.domain;

import com.example.authorization_service.service.Authorities;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.ArrayList;
import java.util.List;

public class UserAuthority {
    
    private List<Authorities> auth;
    
    @NotBlank
    @Size(min = 2, max = 30)
    private String login;
    
    @NotBlank
    @Size(min = 8)
    private String password;
    public void setAuth(List<Authorities> auth) {
        this.auth = auth;
    }
    
    public void setLogin(String login) {
        this.login = login;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    
    public UserAuthority() {
    }
    
    public UserAuthority(String login, String password) {
        this.login = login;
        this.password = password;
        this.auth = new ArrayList<>();
    }
    
    public String getLogin() {
        return login;
    }
    
    public String getPassword() {
        return password;
    }
    
    public List<Authorities> getAuth() {
        return auth;
    }
}
