package it.unicam.cs.mpgc.jbudget122432.model.movements;

import it.unicam.cs.mpgc.jbudget122432.model.users.User;
import jakarta.persistence.Entity;

import java.util.List;


public interface ILedger {
    /**
     * Adds a new {@link Movement} to this ledger.
     * <p>
     * This method ensures that the bidirectional relationship between
     * {@code Ledger} and {@code Movement} is correctly maintained:
     * the given movement is added to the internal list of movements
     * and its {@code ledger} field is updated to reference this
     * {@code Ledger}.
     * </p>
     *
     * @param movement the {@link Movement} to be added; must not be {@code null}
     * @throws IllegalArgumentException if {@code movement} is {@code null}
     */
    boolean addMovement(Movement movement);
    /**
     * Removes the given {@link Movement} from this ledger.
     * <p>
     * This method ensures that the bidirectional relationship between
     * {@code Ledger} and {@code Movement} is correctly maintained:
     * the movement is removed from the internal list and its
     * {@code ledger} field is set to {@code null}.
     * </p>
     *
     * @param movement the {@link Movement} to be removed; must not be {@code null}
     * @throws IllegalArgumentException if {@code movement} is {@code null}
     */
    boolean removeMovement(Movement movement);
    /**
     * Returns an unmodifiable view of all {@link Movement}s stored in this ledger.
     * <p>
     * The returned list reflects the current state of the ledger but cannot
     * be modified directly. To add or remove movements, use
     * {@link #addMovement(Movement)} or {@link #removeMovement(Movement)}.
     * </p>
     *
     * @return an unmodifiable {@link List} of movements associated with this ledger,
     *         never {@code null}
     */
    List<Movement> getMovements();

    User getOwner();

    void setOwner(User owner);
}
