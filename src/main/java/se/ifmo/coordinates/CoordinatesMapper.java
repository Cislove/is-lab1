package se.ifmo.coordinates;

import org.mapstruct.Mapper;
import se.ifmo.common.GenericMapper;

@Mapper(componentModel = "spring")
public interface CoordinatesMapper extends GenericMapper<CoordinatesDto, Coordinates> {
}
