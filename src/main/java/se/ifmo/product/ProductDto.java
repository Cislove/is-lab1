package se.ifmo.product;

import se.ifmo.common.placemark.Dto;
import se.ifmo.model.UnitOfMeasure;

import java.util.Date;

public record ProductDto(
    int id,
    String name,
    int coordinatesId,
    Date creationDate,
    UnitOfMeasure unitOfMeasure,
    int organizationId,
    double price,
    int manufactureCost,
    float rating,
    String partNumber,
    int personId
) implements Dto{
}
