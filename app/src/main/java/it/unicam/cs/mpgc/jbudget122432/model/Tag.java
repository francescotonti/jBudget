package it.unicam.cs.mpgc.jbudget122432.model;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne
    private Tag parent;

    @OneToMany(mappedBy = "parent")
    private Set<Tag> children = new HashSet<>();
}