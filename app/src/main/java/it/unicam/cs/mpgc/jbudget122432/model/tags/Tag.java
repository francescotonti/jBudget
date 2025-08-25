package it.unicam.cs.mpgc.jbudget122432.model.tags;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    @ManyToOne
    private Tag parent;

    @OneToMany(mappedBy = "parent")
    private Set<Tag> children = new HashSet<>();

    public Tag(String name, Tag parent, Set<Tag> children) {
        this.name = name;
        this.parent = parent;
        this.children = children;
    }
}