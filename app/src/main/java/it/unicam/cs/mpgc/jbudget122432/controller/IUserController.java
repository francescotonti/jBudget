package it.unicam.cs.mpgc.jbudget122432.controller;

import it.unicam.cs.mpgc.jbudget122432.model.users.User;

public interface IUserController {
    User createUser(String username);
    User getUserById(long id);
}
