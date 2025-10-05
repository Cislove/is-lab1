package se.ifmo.coordinates;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import se.ifmo.common.GenericMapper;

@Mapper(componentModel = "spring")
public interface CoordinatesMapper extends GenericMapper<CoordinatesDto, Coordinates> {

}
