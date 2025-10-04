package se.ifmo.location;

import org.springframework.stereotype.Service;
import se.ifmo.common.AbstractCrudService;

@Service
public class LocationService extends AbstractCrudService<
        Location,
        LocationRepository,
        LocationDto,
        LocationMapper,
        Long
        >{

    public LocationService(LocationRepository repository, LocationMapper mapper) {
        super(repository, mapper);
    }
}
