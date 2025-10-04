package se.ifmo.address;

import org.mapstruct.Mapper;
import se.ifmo.common.GenericMapper;

@Mapper(componentModel = "spring")
public interface AddressMapper extends GenericMapper<AddressDto, Address> {
}
