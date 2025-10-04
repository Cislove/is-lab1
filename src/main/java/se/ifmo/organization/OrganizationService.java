package se.ifmo.organization;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import se.ifmo.common.AbstractCrudService;

@Service
public class OrganizationService extends AbstractCrudService<
        Organization,
        OrganizationRepository,
        OrganizationDto,
        OrganizationMapper,
        Integer
        >{

    public OrganizationService(OrganizationRepository repository, @Qualifier("organizationMapperImpl") OrganizationMapper mapper) {
        super(repository, mapper);
    }
}
