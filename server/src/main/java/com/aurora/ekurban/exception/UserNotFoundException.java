package com.aurora.ekurban.exception;

/**
 * Kullanıcı bulunamaması/şifre-eposta yanlış olması durumunda hata fırlatılacak olan sınıf
 * @author mehmetercan
 */
public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException() {
        super("eposta adresi veya şifre yanlış.");
    }
}
