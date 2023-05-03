package com.example.authorization_service.repository;

import com.example.authorization_service.domain.UserAuthority;
import com.example.authorization_service.service.Authorities;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static com.example.authorization_service.service.Authorities.*;

@Repository
public class UserRepository {
    
    protected static HashMap<String, UserAuthority> registeredUsers = new HashMap<>();
    
    private final UserAuthority  userAuthority;
    
    public UserRepository(UserAuthority userAuthority) {
        this.userAuthority = userAuthority;
    }
    
    public static void initRegister() {
        
        UserAuthority user1 = new UserAuthority("us1", "password1");
        user1.getAuth().add(READ);
        registeredUsers.put("us1", user1);
        
        UserAuthority user2 = new UserAuthority("us2", "password2");
        user2.getAuth().add(READ);
        user2.getAuth().add(WRITE);
        registeredUsers.put("us2", user2);
        
        UserAuthority user3 = new UserAuthority("us3", "password3");
        user3.getAuth().add(READ);
        user3.getAuth().add(WRITE);
        user3.getAuth().add(DELETE);
        registeredUsers.put("us3", user3);
    }
    
    public List<Authorities> getUserAuthorities(UserAuthority user) {
        UserAuthority userReg = new UserAuthority();
        
        if (registeredUsers.containsKey(user.getLogin())) {
            userReg = registeredUsers.get(user.getLogin());
            if (!userReg.getPassword().equals(user.getPassword())) {
                List<Authorities> auth = new ArrayList<>();
                auth.add(NON);
                return auth;
            }
        }
        return userReg.getAuth();
    }
    
}
