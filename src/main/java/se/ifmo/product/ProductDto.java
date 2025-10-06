package se.ifmo.product;

import se.ifmo.common.placemark.Dto;
import se.ifmo.coordinates.Coordinates;
import se.ifmo.coordinates.CoordinatesDto;
import se.ifmo.model.UnitOfMeasure;
import se.ifmo.organization.OrganizationDto;
import se.ifmo.person.PersonDto;

import java.util.Date;

public record ProductDto(
    int id,
    String name,
    CoordinatesDto coordinates,
    Date creationDate,
    UnitOfMeasure unitOfMeasure,
    OrganizationDto organization,
    double price,
    int manufactureCost,
    float rating,
    String partNumber,
    PersonDto person
) implements Dto{
}
