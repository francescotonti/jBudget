package it.unicam.cs.mpgc.jbudget122432.controller;

import it.unicam.cs.mpgc.jbudget122432.model.tags.Tag;
import it.unicam.cs.mpgc.jbudget122432.model.users.User;

import java.util.Map;

public interface IStatisticsController {
    /**
     * Returns the total expenses for the specified user and tag.
     *
     * @param user the {@link User} whose expenses are queried, must not be {@code null}
     * @param tag  the {@link Tag} category used to filter movements, must not be {@code null}
     * @return the total expenses for the given tag
     * @throws IllegalArgumentException if {@code user} or {@code tag} is {@code null}
     */
    double getTotalExpensesByTag(User user, Tag tag);
    /**
     * Returns the total income for the specified user and tag.
     *
     * @param user the {@link User} whose income is queried, must not be {@code null}
     * @param tag  the {@link Tag} category used to filter movements, must not be {@code null}
     * @return the total income for the given tag
     * @throws IllegalArgumentException if {@code user} or {@code tag} is {@code null}
     */
    double getTotalIncomeByTag(User user, Tag tag);
    /**
     * Returns the total expenses grouped by tag for the specified user.
     *
     * @param user the {@link User} whose expenses are queried, must not be {@code null}
     * @return a map associating each {@link Tag} with the total expenses in that category,
     *         never {@code null} (may be empty)
     * @throws IllegalArgumentException if {@code user} is {@code null}
     */
    Map<Tag, Double> getExpensesPerCategory(User user);
    /**
     * Returns the total income grouped by tag for the specified user.
     *
     * @param user the {@link User} whose income is queried, must not be {@code null}
     * @return a map associating each {@link Tag} with the total income in that category,
     *         never {@code null} (may be empty)
     * @throws IllegalArgumentException if {@code user} is {@code null}
     */
    Map<Tag, Double> getIncomePerCategory(User user);
}
