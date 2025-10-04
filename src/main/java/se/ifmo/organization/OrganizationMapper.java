package se.ifmo.organization;

import org.mapstruct.Mapper;
import se.ifmo.common.GenericMapper;

@Mapper(componentModel = "spring")
public interface OrganizationMapper extends GenericMapper<OrganizationDto, Organization> {
}
