package se.ifmo.organization;

import org.springframework.stereotype.Repository;
import se.ifmo.common.placemark.AbstractRepository;

@Repository
public interface OrganizationRepository extends AbstractRepository<Organization, Integer> {
}
