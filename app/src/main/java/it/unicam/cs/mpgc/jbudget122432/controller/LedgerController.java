package it.unicam.cs.mpgc.jbudget122432.controller;

import it.unicam.cs.mpgc.jbudget122432.model.movements.ILedger;
import it.unicam.cs.mpgc.jbudget122432.model.movements.Movement;
import it.unicam.cs.mpgc.jbudget122432.model.movements.MovementType;
import it.unicam.cs.mpgc.jbudget122432.model.users.User;

import java.util.List;

public class LedgerController implements ILedgerController {

    @Override
    public void addMovement(Movement movement, User owner, ILedger ledger) {
        if(ledger.getOwner().equals(owner)) {
            ledger.addMovement(movement);
        }
    }

    @Override
    public void removeMovement(Movement movement, User owner, ILedger ledger) {
        if(ledger.getOwner().equals(owner)) {
            ledger.removeMovement(movement);
        }
    }

    @Override
    public List<Movement> getMovements(ILedger ledger) {
        return ledger.getMovements();
    }

    @Override
    public double getBalance(ILedger ledger) {
        List<Movement> movements = getMovements(ledger);
        double positive = movements.stream().
                                    filter(movement -> movement.getType()== MovementType.INCOME).
                                    map(Movement::getAmount).
                                    reduce(0.0, Double::sum);
        double negative = movements.stream().
                                    filter(movement -> movement.getType()== MovementType.EXPENSE).
                                    map(Movement::getAmount).
                                    reduce(0.0, Double::sum);
        return positive - negative;
    }
}
