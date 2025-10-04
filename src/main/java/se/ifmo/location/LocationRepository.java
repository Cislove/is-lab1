package se.ifmo.location;

import org.springframework.stereotype.Repository;
import se.ifmo.common.placemark.AbstractRepository;

@Repository
public interface LocationRepository extends AbstractRepository<Location, Long> {
}
