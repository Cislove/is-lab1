package se.ifmo.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private float x;

    @Column(nullable = false)
    private Long y; //Поле не может быть null

    @Column(nullable = false)
    private Long z; //Поле не может быть null
}
