package it.unicam.cs.mpgc.jbudget122432.model.users;

import it.unicam.cs.mpgc.jbudget122432.model.movements.Ledger;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@EqualsAndHashCode
public class User{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String username;

    @ManyToOne
    @JoinColumn(name = "ledger_id")
    private Ledger ledger;


}
