package ru.netology.services;

import org.springframework.stereotype.Service;
import ru.netology.helpers.Authorities;
import ru.netology.helpers.User;
import ru.netology.repositories.UserRepository;
import ru.netology.selfMadeExceptions.InvalidCredentials;
import ru.netology.selfMadeExceptions.UnauthorizedUser;

import java.util.List;
@Service
public class AuthorizationService {
    private final UserRepository userRepository;

    public AuthorizationService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

//    public List<Authorities> getAuthorities(String user, String password){
//        if (isEmpty(user) || isEmpty(password)) {
//            throw new InvalidCredentials("User name or password is empty");
//        }
//        List<Authorities> userAuthorities = userRepository.getUserAuthorities(user, password);
//        if (isEmpty(userAuthorities)) {
//            throw new UnauthorizedUser("Unknown user " + user);
//        }
//        return userAuthorities;
//    }

    private boolean isEmpty(String str) {
        return str == null || str.isEmpty();
    }
    private boolean isEmpty(List<?> str) {
        return str == null || str.isEmpty();
    }

    public List<Authorities> getAuthorities(User user) {
        if (isEmpty(user.getName()) || isEmpty(user.getPassword())) {
            throw new InvalidCredentials("User name or password is empty");
        }
        List<Authorities> userAuthorities = userRepository.getUserAuthorities(user);
        if (isEmpty(userAuthorities)) {
            throw new UnauthorizedUser("Unknown user " + user);
        }
        return userAuthorities;
    }
}
