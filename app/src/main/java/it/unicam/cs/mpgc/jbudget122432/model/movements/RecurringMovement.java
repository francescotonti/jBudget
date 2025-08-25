package it.unicam.cs.mpgc.jbudget122432.model.movements;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Entity
@Getter
@Setter
public class RecurringMovement extends Movement {

    private Frequency frequency;

    private Timestamp nextDueDate;

    private MovementType type;



}
