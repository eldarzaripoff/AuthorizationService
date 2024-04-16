package ru.netology.repositories;

import org.springframework.stereotype.Repository;
import ru.netology.helpers.Authorities;
import ru.netology.helpers.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Repository
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

    public List<Authorities> getUserAuthorities(User user) {
        if (user == null) {
            return new ArrayList<>();
        }
        for (Map.Entry<User, List<Authorities>> entry: userListMap.entrySet()) {
            if (entry.getKey().getName().equals(user.getName()) && entry.getKey().getPassword().equals(user.getPassword())) {
                return entry.getValue();
            }
        }
        return new ArrayList<>();
    }
}
