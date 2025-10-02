package se.ifmo.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Check;

@Entity
@Getter
@Setter
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 83)
    private String street; //Длина строки не должна быть больше 83, Поле может быть null

    @Column(nullable = false)
    @Check(constraints = "length(zip_code) >= 7")
    private String zipCode; //Длина строки должна быть не меньше 7, Поле не может быть null

    @ManyToOne
    @JoinColumn(nullable = false, name = "location_id")
    private Location town; //Поле не может быть null
}
