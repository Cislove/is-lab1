package se.ifmo.person;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import se.ifmo.common.AbstractCrudService;

import java.util.Map;
import java.util.Set;

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

    @Override
    public String getEntityName() {
        return "person";
    }

    @Override
    protected Set<String> getAllowedSearchFields() {
        return Set.of("name");
    }

    @Override
    protected Map<String, String> getFieldMapping() {
        return Map.of("name", "name");
    }
}
