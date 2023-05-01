package com.example.authorization_service.error;

public class InvalidPassword extends RuntimeException {
    
    public InvalidPassword(String msg) {
        super(msg);
    }
}
