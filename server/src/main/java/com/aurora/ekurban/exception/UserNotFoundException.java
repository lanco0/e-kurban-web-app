package com.aurora.ekurban.exception;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException() {
        super("eposta adresi veya şifre yanlış.");
    }
}
