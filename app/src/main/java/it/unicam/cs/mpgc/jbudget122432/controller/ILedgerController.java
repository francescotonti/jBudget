package it.unicam.cs.mpgc.jbudget122432.controller;

import it.unicam.cs.mpgc.jbudget122432.model.movements.ILedger;
import it.unicam.cs.mpgc.jbudget122432.model.movements.Movement;
import it.unicam.cs.mpgc.jbudget122432.model.users.User;

import java.util.List;

public interface ILedgerController {
    void addMovement(Movement movement, User owner, ILedger ledger);
    void removeMovement(Movement movement, User owner, ILedger ledger);
    List<Movement> getMovements(ILedger ledger);
    double getBalance(ILedger ledger);
}
