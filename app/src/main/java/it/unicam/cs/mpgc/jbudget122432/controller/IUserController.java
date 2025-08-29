package it.unicam.cs.mpgc.jbudget122432.controller;

import it.unicam.cs.mpgc.jbudget122432.model.users.User;

public interface IUserController {
    /**
     * Creates a new {@link User} with the specified username.
     *
     * @param username the username of the new user, must not be {@code null} or empty
     * @return the newly created {@link User} instance, never {@code null}
     * @throws IllegalArgumentException if {@code username} is {@code null} or empty
     */
    User createUser(String username);
    /**
     * Retrieves an existing {@link User} by their unique identifier.
     *
     * @param id the unique identifier of the user, must be a positive number
     * @return the {@link User} with the given id, or {@code null} if no such user exists
     */
    User getUserById(long id);
}
