package it.unicam.cs.mpgc.jbudget122432.test;

import static org.junit.jupiter.api.Assertions.*;

import it.unicam.cs.mpgc.jbudget122432.model.movements.*;
import it.unicam.cs.mpgc.jbudget122432.controller.ILedgerController;
import it.unicam.cs.mpgc.jbudget122432.controller.IUserController;
import it.unicam.cs.mpgc.jbudget122432.controller.LedgerController;
import it.unicam.cs.mpgc.jbudget122432.controller.UserController;
import it.unicam.cs.mpgc.jbudget122432.model.users.User;
import it.unicam.cs.mpgc.jbudget122432.model.users.UserRepository;
import org.junit.jupiter.api.Test;

import java.sql.Timestamp;

public class LedgerTest {
    @Test
    public void addMovement(){
        UserRepository userRepository = new UserRepository();
        IUserController userController = new UserController(userRepository);
        User u = userController.createUser("user1");
        ILedgerController ledgerController = new LedgerController();
        assertThrows(IllegalArgumentException.class,()->ledgerController.addMovement(null,null,null));
        Movement movement = new Movement("Rent",300.0,
                new Timestamp(System.currentTimeMillis()),MovementType.EXPENSE,u);
        ledgerController.addMovement(movement,u,u.getLedger());
        assertEquals(1, u.getLedger().getMovements().size());

    }
}
