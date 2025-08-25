package it.unicam.cs.mpgc.jbudget122432.model.users;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class UserRepository {
    private final List<User> users;

    public UserRepository() {
        users = new ArrayList<>();
    }

    public void add(User user) {
        users.add(user);
    }

    public void remove(User user) {
        users.remove(user);
    }
}
