package ru.netology.repositories;

import ru.netology.helpers.Authorities;
import ru.netology.helpers.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserRepository {
    Map<User, List<Authorities>> userListMap = new HashMap<>();

    public UserRepository() {
        userListMap.put(new User("brian", "newYork"), List.of(Authorities.READ, Authorities.DELETE, Authorities.WRITE));
        userListMap.put(new User("john", "florida"), List.of(Authorities.READ, Authorities.WRITE));
        userListMap.put(new User("jovanni", "rome"), List.of(Authorities.READ));
        userListMap.put(new User("salvador", "mexico"), List.of(Authorities.READ, Authorities.DELETE, Authorities.WRITE));
    }

    public List<Authorities> getUserAuthorities(String user, String password) {
        for (Map.Entry<User, List<Authorities>> entry: userListMap.entrySet()) {
            if (entry.getKey().getName().equals(user) && entry.getKey().getPassword().equals(password)) {
                return entry.getValue();
            }
        }
        return new ArrayList<>();
    }
}
