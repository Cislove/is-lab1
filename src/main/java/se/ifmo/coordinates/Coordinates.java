package se.ifmo.coordinates;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Check;
import se.ifmo.common.placemark.AbstractEntity;

@Entity
@Getter
@Setter
public class Coordinates implements AbstractEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double x;

    @Check(constraints = "length(y) > -718")
    private float y; //Значение поля должно быть больше -718
}
