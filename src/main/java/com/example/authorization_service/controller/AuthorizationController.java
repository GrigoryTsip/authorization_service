package com.example.authorization_service.controller;

import com.example.authorization_service.annotation.HandlerMethodArgumentResolver;
import com.example.authorization_service.domain.UserAuthority;
import com.example.authorization_service.service.Authorities;
import com.example.authorization_service.service.AuthorizationService;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AuthorizationController {
    
    AuthorizationService service = new AuthorizationService();
    
    // ������ ���� ���������, ������� ������ ������ � ��������� ������ UserAuthority
    @GetMapping("/authorize")
    @HandlerMethodArgumentResolver
    public List<Authorities> getAuthorities(@Valid UserAuthority user) {
        return service.getAuthorities(user);
    }
}
