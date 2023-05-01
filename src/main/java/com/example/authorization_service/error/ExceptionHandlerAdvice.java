package com.example.authorization_service.error;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandlerAdvice {
    
    @ExceptionHandler(UnauthorizedUser.class)
    public ResponseEntity<String> unauthorizedUser(UnauthorizedUser e) {
        return new ResponseEntity<>("Unknown user", HttpStatus.UNAUTHORIZED);
        
    }
    
    @ExceptionHandler(InvalidCredentials.class)
    public ResponseEntity<String> iInvalidCredentials(InvalidCredentials e) {
        return new ResponseEntity<>("User name or password is empty", HttpStatus.BAD_REQUEST);
    }
    
    @ExceptionHandler(InvalidPassword.class)
    public ResponseEntity<String> iInvalidPassword(InvalidPassword e) {
        return new ResponseEntity<>("Wrong password fo this user", HttpStatus.NOT_IMPLEMENTED);
    }
}
