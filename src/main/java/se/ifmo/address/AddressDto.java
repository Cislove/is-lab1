package se.ifmo.address;

import se.ifmo.common.placemark.Dto;

import java.io.Serializable;

public record AddressDto(
    int id,
    String street,
    String zipCode,
    int locationId
) implements Dto {
}
