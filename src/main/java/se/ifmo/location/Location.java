package se.ifmo.location;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import se.ifmo.common.AbstractEntity;

@Entity
@Getter
@Setter
public class Location implements AbstractEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private float x;

    @Column(nullable = false)
    private Long y; //Поле не может быть null

    @Column(nullable = false)
    private Long z; //Поле не может быть null

    @Override
    public String getStringId() {
        return String.valueOf(id);
    }
}
