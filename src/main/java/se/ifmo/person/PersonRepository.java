package se.ifmo.person;

import org.springframework.stereotype.Repository;
import se.ifmo.common.placemark.AbstractRepository;

@Repository
public interface PersonRepository extends AbstractRepository<Person, Long> {
}
