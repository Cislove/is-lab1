package se.ifmo.person;

import se.ifmo.common.placemark.Dto;
import se.ifmo.model.Color;
import se.ifmo.model.Country;

import java.util.Date;

public record PersonDto(
    int id,
    String name,
    Color eyeColor,
    Color hairColor,
    int locationId,
    Date birthday,
    Country nationality
) implements Dto {
}
