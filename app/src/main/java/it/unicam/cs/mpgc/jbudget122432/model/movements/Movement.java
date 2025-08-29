package it.unicam.cs.mpgc.jbudget122432.model.movements;

import it.unicam.cs.mpgc.jbudget122432.model.tags.Tag;
import it.unicam.cs.mpgc.jbudget122432.model.users.User;
import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Movement {
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

    public Movement(String description, double amount, Timestamp date, MovementType type, User sender) {
        this.description = description;
        this.amount = amount;
        this.date = date;
        this.type = type;
        this.sender = sender;
        this.tags = new HashSet<>();
    }

    public void addTag(Tag tag){
        tags.add(tag);
    }

}
