package com.example.authorization_service.service;

import com.example.authorization_service.error.ExceptionHandlerAdvice;
import com.example.authorization_service.error.InvalidCredentials;
import com.example.authorization_service.error.InvalidPassword;
import com.example.authorization_service.error.UnauthorizedUser;
import com.example.authorization_service.repository.UserRepository;

import java.util.List;

import static com.example.authorization_service.service.Authorities.NON;

public class AuthorizationService {
    
    UserRepository userRepository = new UserRepository();
    
    public List<Authorities> gettAuthorities(String user, String password) {
        if (isEmpty(user) || isEmpty(password)) {
            throw new InvalidCredentials("Логин или пароль пусты");
        }
        List<Authorities> userAuthorities = userRepository.getUserAuthorities(user, password);
        if (isEmpty(userAuthorities)) {
            throw new UnauthorizedUser("Незарегистрированный пользователь " + user);
        }
        
        if (userAuthorities.get(0) == NON) {
            throw new InvalidPassword("Неверный пароль пользователя " + user);
        }
        
        return userAuthorities;
    }
    
    private boolean isEmpty(String str) {
        return str == null || str.isEmpty();
    }
    
    private boolean isEmpty(List<?> str) {
        return str == null || str.isEmpty();
    }
}
