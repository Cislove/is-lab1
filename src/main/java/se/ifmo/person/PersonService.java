package se.ifmo.person;

import org.springframework.stereotype.Service;
import se.ifmo.common.AbstractCrudService;

@Service
public class PersonService extends AbstractCrudService<
        Person,
        PersonRepository,
        PersonDto,
        PersonMapper,
        Long
        > {
    public PersonService(PersonRepository repository, PersonMapper mapper) {
        super(repository, mapper);
    }
}
