package it.unicam.cs.mpgc.jbudget122432.controller;

import it.unicam.cs.mpgc.jbudget122432.model.movements.Ledger;
import it.unicam.cs.mpgc.jbudget122432.model.users.User;
import it.unicam.cs.mpgc.jbudget122432.model.users.UserRepository;

import java.util.List;
import java.util.Optional;

public class UserController implements IUserController{
    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public User createUser(String username) {
        List<User> users = userRepository.getUsers();
        List<String> usernameList = users.stream().
                                        map(User::getUsername).
                                        toList();
        if(usernameList.contains(username)) {
            throw new IllegalArgumentException("Username already exists");
        }
        User u = new User();
        u.setUsername(username);
        u.setLedger(new Ledger());
        userRepository.add(u);
        return u;
    }

    @Override
    public User getUserById(long id) {
        List<User> users = userRepository.getUsers();
        Optional<User> u = users.stream().
                filter(user->user.getId()==id).findFirst();
        return u.orElse(null);
    }
}
