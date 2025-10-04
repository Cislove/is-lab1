package se.ifmo.person;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import se.ifmo.common.AbstractCrudService;

@Service
public class PersonService extends AbstractCrudService<
        Person,
        PersonRepository,
        PersonDto,
        PersonMapper,
        Integer
        > {
    public PersonService(PersonRepository repository, @Qualifier("personMapperImpl") PersonMapper mapper) {
        super(repository, mapper);
    }
}
