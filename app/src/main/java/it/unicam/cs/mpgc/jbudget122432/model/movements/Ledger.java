package it.unicam.cs.mpgc.jbudget122432.model.movements;

import it.unicam.cs.mpgc.jbudget122432.model.users.User;
import jakarta.persistence.*;
import lombok.Getter;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
public class Ledger implements ILedger{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @OneToMany(mappedBy = "ledger",cascade = CascadeType.ALL)
    private List<Movement> movements;

    @ManyToOne(optional = false)
    private User owner;

    public Ledger() {
        movements = new ArrayList<>();
    }
    
    public Ledger(User owner){
        this.owner = owner;
        movements = new ArrayList<Movement>();
    }

    @Override
    public boolean removeMovement(Movement movement) {
        if(movements.contains(movement)){
            movements.remove(movement);
            return true;
        }
        return false;
    }

    @Override
    public List<Movement> getMovements() {
        return movements;
    }

    @Override
    public boolean addMovement(Movement movement) {
        if(movements.contains(movement))
            return false;
        movements.add(movement);
        return true;
    }
}
