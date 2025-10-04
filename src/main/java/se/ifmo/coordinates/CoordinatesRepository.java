package se.ifmo.coordinates;

import org.springframework.stereotype.Repository;
import se.ifmo.common.placemark.AbstractRepository;

@Repository
public interface CoordinatesRepository extends AbstractRepository<Coordinates, Long> {
}
