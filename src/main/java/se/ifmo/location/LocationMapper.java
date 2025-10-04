package se.ifmo.location;

import org.mapstruct.Mapper;
import se.ifmo.common.GenericMapper;

@Mapper(componentModel = "spring")
public interface LocationMapper extends GenericMapper<LocationDto, Location>{
}
