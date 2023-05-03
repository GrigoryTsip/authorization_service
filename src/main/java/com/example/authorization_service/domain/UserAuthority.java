package com.example.authorization_service.domain;

import com.example.authorization_service.service.Authorities;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.jetbrains.annotations.Contract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
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
    
    @Autowired
    public UserAuthority() {
    }
    
    public UserAuthority(String login, String password) {
        this.login = login;
        this.password = password;
        this.auth = new ArrayList<>();
    }
    
    public void setLogin(String login) {
        this.login = login;
    }
    
    public void setPassword(String password) {
        this.password = password;
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
