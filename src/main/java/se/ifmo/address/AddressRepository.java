package se.ifmo.address;

import org.springframework.stereotype.Repository;
import se.ifmo.common.placemark.AbstractRepository;

@Repository
public interface AddressRepository extends AbstractRepository<Address, Long> {
}
