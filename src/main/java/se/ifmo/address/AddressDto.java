package se.ifmo.address;

import se.ifmo.common.placemark.Dto;
import se.ifmo.location.LocationDto;

import java.io.Serializable;

public record AddressDto(
    int id,
    String street,
    String zipCode,
    LocationDto town
) implements Dto {
}
