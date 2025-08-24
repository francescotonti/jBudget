package it.unicam.cs.mpgc.jbudget122432.model.movements;

import it.unicam.cs.mpgc.jbudget122432.model.Tag;
import it.unicam.cs.mpgc.jbudget122432.model.users.User;
import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;
import java.util.Set;

@Entity
@Getter
@Setter
public final class Movement {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String description;

    private double amount;

    private Timestamp date;

    private MovementType type;

    @ManyToOne
    @JoinColumn(name = "sender_id")
    private User sender;

    @OneToMany
    private Set<Tag> tags;

}
