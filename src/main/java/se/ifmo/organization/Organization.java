package se.ifmo.organization;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Check;
import se.ifmo.address.Address;
import se.ifmo.common.placemark.AbstractEntity;
import se.ifmo.model.OrganizationType;
import se.ifmo.person.Person;

@Entity
@Getter
@Setter
public class Organization implements AbstractEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id; //Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически

    @Column(nullable = false)
    @Check(constraints = "length(name) > 0")
    private String name; //Поле не может быть null, Строка не может быть пустой

    @JoinColumn(name = "address_id", nullable = false)
    @ManyToOne
    private Address officialAddress; //Поле не может быть null

    @Column(nullable = false)
    @Check(constraints = "annual_turnover > 0")
    private Integer annualTurnover; //Поле не может быть null, Значение поля должно быть больше 0

    @Check(constraints = "employees_count > 0")
    private long employeesCount; //Значение поля должно быть больше 0

    @Column(nullable = false, length = 1789)
    private String fullName; //Длина строки не должна быть больше 1789, Поле не может быть null

    @Check(constraints = "rating > 0")
    private int rating; //Значение поля должно быть больше 0

    @Enumerated(EnumType.STRING)
    private OrganizationType type; //Поле может быть null
}
