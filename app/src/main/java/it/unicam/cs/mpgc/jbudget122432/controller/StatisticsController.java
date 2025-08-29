package it.unicam.cs.mpgc.jbudget122432.controller;

import it.unicam.cs.mpgc.jbudget122432.model.tags.Tag;
import it.unicam.cs.mpgc.jbudget122432.model.movements.Movement;
import it.unicam.cs.mpgc.jbudget122432.model.movements.MovementType;
import it.unicam.cs.mpgc.jbudget122432.model.tags.TagRepository;
import it.unicam.cs.mpgc.jbudget122432.model.users.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StatisticsController implements IStatisticsController {
    private final TagRepository tagRepo;

    public StatisticsController(TagRepository tagRepo) {
        this.tagRepo = tagRepo;
    }


    @Override
    public double getTotalExpensesByTag(User user, Tag tag) {
        if(user==null || tag==null)
            throw new IllegalArgumentException();
        List<Movement> movements = user.getLedger().getMovements();
        return movements.stream().
                        filter(movement->movement.getType()== MovementType.EXPENSE).
                        filter(movement->movement.getTags().contains(tag)).
                        map(Movement::getAmount).
                        reduce(0.0, Double::sum);
    }

    @Override
    public double getTotalIncomeByTag(User user, Tag tag) {
        if(user==null || tag==null)
            throw new IllegalArgumentException();
        List<Movement> movements = user.getLedger().getMovements();
        return movements.stream().
                filter(movement->movement.getType()== MovementType.INCOME).
                filter(movement->movement.getTags().contains(tag)).
                map(Movement::getAmount).
                reduce(0.0, Double::sum);
    }

    @Override
    public Map<Tag, Double> getExpensesPerCategory(User user) {
        if(user==null)
            throw new IllegalArgumentException();
        List<Tag> tags = tagRepo.getTags();
        Map<Tag, Double> expensesPerCategory = new HashMap<>();
        for(Tag tag : tags) {
            expensesPerCategory.put(tag, getTotalExpensesByTag(user, tag));
        }
        return expensesPerCategory;
    }

    @Override
    public Map<Tag, Double> getIncomePerCategory(User user) {
        if(user==null)
            throw new IllegalArgumentException();
        List<Tag> tags = tagRepo.getTags();
        Map<Tag, Double> incomePerCategory = new HashMap<>();
        for(Tag tag : tags) {
            incomePerCategory.put(tag, getTotalIncomeByTag(user, tag));
        }
        return incomePerCategory;
    }
}
