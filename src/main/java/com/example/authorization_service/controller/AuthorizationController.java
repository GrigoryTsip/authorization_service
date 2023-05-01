package com.example.authorization_service.controller;

import com.example.authorization_service.service.Authorities;
import com.example.authorization_service.service.AuthorizationService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AuthorizationController {
    
    AuthorizationService service = new AuthorizationService();
    
    @GetMapping("/authorize")
    public List<Authorities> getAuthorities(@RequestParam("user") String user, @RequestParam("password") String password) {
        return service.gettAuthorities(user, password);
    }
}
