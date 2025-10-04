package se.ifmo.coordinates;

import se.ifmo.common.placemark.Dto;

public record CoordinatesDto(
        int id,
        double x,
        float y
) implements Dto {
}
