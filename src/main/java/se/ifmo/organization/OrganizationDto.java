package se.ifmo.organization;

import se.ifmo.address.AddressDto;
import se.ifmo.common.placemark.Dto;
import se.ifmo.model.OrganizationType;

public record OrganizationDto(
        int id,
        String name,
        AddressDto officialAddress,
        int annualTurnover,
        long employeesCount,
        String fullName,
        int rating,
        OrganizationType type
) implements Dto {
}
