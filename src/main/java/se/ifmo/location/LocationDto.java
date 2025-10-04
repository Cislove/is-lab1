package se.ifmo.location;

import se.ifmo.common.placemark.Dto;

public record LocationDto(
        int id,
        float x,
        long y,
        long z
) implements Dto {
}
