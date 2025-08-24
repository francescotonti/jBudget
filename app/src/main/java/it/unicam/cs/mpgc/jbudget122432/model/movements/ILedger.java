package it.unicam.cs.mpgc.jbudget122432.model.movements;

import java.util.List;

public interface ILedger {
    boolean addMovement(Movement movement);
    boolean removeMovement(Movement movement);
    List<Movement> getMovements();
}
