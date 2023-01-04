package com.aurora.ekurban.service;

import com.aurora.ekurban.domain.User;
import com.aurora.ekurban.exception.UserNotFoundException;
import com.aurora.ekurban.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Controllerın kullanıcı login ve logout işlemleri için iletişime geçtiği sınıf nesnesi
 */
@Service
public class UserService {
    private final UserRepository userReposiory;

    /**
     * @param userReposiory constructor ile repository inject ediliyor
     */
    public UserService(UserRepository userReposiory) {
        this.userReposiory = userReposiory;
    }

    /**
     * @param eposta Database de aranılacak olan eposta/kullanıcı adı alanı
     * @return repositoryde girilen eposta ile kayırlı olan tüm alanları liste halinde geri döndürür
     */
    public List<User> findUser(String eposta) {
        return userReposiory.findUserByEposta(eposta);
    }

    /**
     * @param _user Kullanıcının girdiği eposta/kullanıcı adı ve şifreyi içeren domain sınıfımız
     * @return Kullanıcı database de kayıtlı ise true, kayıtlı değilse false değeri döner
     */
    public Optional<User> validate(User _user) {
        Optional<User> user = Optional.ofNullable(this.findUser(_user.getEposta()).stream().findFirst()
                .orElseThrow(() -> new UserNotFoundException()));

        if (user.isPresent()) {
            String passwordInDatabase = user.get().getSifre();
            String userEnteredPassword = _user.getSifre();
            if (passwordInDatabase.equals(userEnteredPassword)) {
                return user;
            }
        }

        throw new UserNotFoundException();
    }

    public Boolean logout() {
        return true;
    }
}
