package com.example.authorization_service.service;

import com.example.authorization_service.error.ExceptionHandlerAdvice;
import com.example.authorization_service.error.InvalidCredentials;
import com.example.authorization_service.error.InvalidPassword;
import com.example.authorization_service.error.UnauthorizedUser;
import com.example.authorization_service.repository.UserRepository;

import java.util.List;

import static com.example.authorization_service.service.Authorities.NON;

@Service
public class AuthorizationService {
    
    private final UserRepository userRepository;
    
    public AuthorizationService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    
    public List<Authorities> gettAuthorities(String user, String password) {
        if (isEmpty(user) || isEmpty(password)) {
            throw new InvalidCredentials("Ëîãèí èëè ïàðîëü ïóñòû");
        }
        List<Authorities> userAuthorities = userRepository.getUserAuthorities(user, password);
        if (isEmpty(userAuthorities)) {
            throw new UnauthorizedUser("Íåçàðåãèñòðèðîâàííûé ïîëüçîâàòåëü " + user);
        }
        
        if (userAuthorities.get(0) == NON) {
            throw new InvalidPassword("Íåâåðíûé ïàðîëü ïîëüçîâàòåëÿ " + user);
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
