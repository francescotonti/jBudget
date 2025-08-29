package it.unicam.cs.mpgc.jbudget122432.model.movements;

import it.unicam.cs.mpgc.jbudget122432.model.users.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Entity
@Getter
@Setter
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
        movements = new ArrayList<>();
    }

    @Override
    public boolean removeMovement(Movement movement) {
        if(movement==null)
            throw new IllegalArgumentException("Movement cannot be null");
        if(movements.contains(movement)){
            movements.remove(movement);
            return true;
        }
        return false;
    }

    @Override
    public List<Movement> getMovements() {
        return Collections.unmodifiableList(movements);
    }

    @Override
    public boolean addMovement(Movement movement) {
        if(movement==null)
            throw new IllegalArgumentException("Movement cannot be null");
        if(movements.contains(movement))
            return false;
        movements.add(movement);
        return true;
    }
}
