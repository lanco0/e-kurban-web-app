package com.aurora.ekurban.exception;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String eposta) {
        super(eposta + " adresi/şifre yanlış.");
    }
}
