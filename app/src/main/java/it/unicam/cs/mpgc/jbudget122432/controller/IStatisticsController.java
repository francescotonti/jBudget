package it.unicam.cs.mpgc.jbudget122432.controller;

import it.unicam.cs.mpgc.jbudget122432.model.tags.Tag;
import it.unicam.cs.mpgc.jbudget122432.model.users.User;

import java.util.Map;

public interface IStatisticsController {
    double getTotalExpensesByTag(User user, Tag tag);
    double getTotalIncomeByTag(User user, Tag tag);
    Map<Tag, Double> getExpensesPerCategory(User user);
    Map<Tag, Double> getIncomePerCategory(User user);
}
