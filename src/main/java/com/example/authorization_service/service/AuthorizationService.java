package com.example.authorization_service.service;

import com.example.authorization_service.domain.UserAuthority;
import com.example.authorization_service.error.InvalidPassword;
import com.example.authorization_service.error.UnauthorizedUser;
import com.example.authorization_service.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.example.authorization_service.service.Authorities.NON;
@Service
public class AuthorizationService {
    
    private final UserRepository userRepository;
    
    public AuthorizationService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    
    public List<Authorities> getAuthorities(UserAuthority user) {
        /*
        if (isEmpty(user) || isEmpty(password)) {
            throw new InvalidCredentials("User name or password is empty");
        }
        
        */
        List<Authorities> userAuthorities = userRepository.getUserAuthorities(user);
        if (isEmpty(userAuthorities)) {
            throw new UnauthorizedUser("Unrtgistered user " + user);
        }
        
        if (userAuthorities.get(0) == NON) {
            throw new InvalidPassword("Wrong password " + user);
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
