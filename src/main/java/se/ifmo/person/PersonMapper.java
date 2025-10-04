package se.ifmo.person;

import org.mapstruct.Mapper;
import se.ifmo.common.GenericMapper;

@Mapper(componentModel = "spring")
public interface PersonMapper extends GenericMapper<PersonDto, Person> {
}
