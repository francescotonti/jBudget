package it.unicam.cs.mpgc.jbudget122432.model.users;

import jakarta.persistence.*;

@Entity
public class User{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;

}
