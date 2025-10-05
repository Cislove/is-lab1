package se.ifmo.coordinates;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Check;
import se.ifmo.common.AbstractEntity;

@Entity
@Getter
@Setter
public class Coordinates implements AbstractEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private double x;

    @Check(constraints = "y > -718")
    private float y; //Значение поля должно быть больше -718

    @Override
    public String getStringId() {
        return String.valueOf(id);
    }
}
