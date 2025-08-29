package it.unicam.cs.mpgc.jbudget122432.controller;

import it.unicam.cs.mpgc.jbudget122432.model.movements.ILedger;
import it.unicam.cs.mpgc.jbudget122432.model.movements.Movement;
import it.unicam.cs.mpgc.jbudget122432.model.users.User;

import java.util.List;

public interface ILedgerController {
    /**
     * Adds a new movement to the specified ledger for a given owner.
     *
     * @param movement the {@link Movement} to add, must not be {@code null}
     * @param owner    the {@link User} who owns the ledger, must not be {@code null}
     * @param ledger   the {@link ILedger} where the movement will be stored, must not be {@code null}
     * @throws IllegalArgumentException if any argument is {@code null}
     * @throws SecurityException if the user is not authorized to modify the ledger
     */
    void addMovement(Movement movement, User owner, ILedger ledger);
    /**
     * Removes an existing movement from the specified ledger for a given owner.
     *
     * @param movement the {@link Movement} to remove, must not be {@code null}
     * @param owner    the {@link User} who owns the ledger, must not be {@code null}
     * @param ledger   the {@link ILedger} from which the movement will be removed, must not be {@code null}
     * @throws IllegalArgumentException if any argument is {@code null}
     * @throws SecurityException if the user is not authorized to modify the ledger
     */
    void removeMovement(Movement movement, User owner, ILedger ledger);
    /**
     * Retrieves all movements stored in the specified ledger.
     *
     * @param ledger the {@link ILedger} to query, must not be {@code null}
     * @return a list of all {@link Movement} objects in the ledger,
     *         never {@code null} (may be empty)
     * @throws IllegalArgumentException if ledger is {@code null}
     */
    List<Movement> getMovements(ILedger ledger);
    /**
     * Computes the current balance of the specified ledger.
     *
     * @param ledger the {@link ILedger} to query, must not be {@code null}
     * @return the net balance, where positive values indicate income
     *         and negative values indicate expenses
     * @throws IllegalArgumentException if ledger is {@code null}
     */
    double getBalance(ILedger ledger);

    double getIncome(ILedger ledger);

    double getExpense(ILedger ledger);
}
