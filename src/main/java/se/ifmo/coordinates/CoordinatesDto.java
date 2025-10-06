package se.ifmo.coordinates;

import se.ifmo.common.placemark.Dto;

public record CoordinatesDto(
        Integer id,
        double x,
        double y
) implements Dto {

}
