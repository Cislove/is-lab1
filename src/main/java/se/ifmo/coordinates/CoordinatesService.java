package se.ifmo.coordinates;

import se.ifmo.common.AbstractCrudService;

public class CoordinatesService extends AbstractCrudService<
        Coordinates,
        CoordinatesRepository,
        CoordinatesDto,
        CoordinatesMapper,
        Long
        >{

    public CoordinatesService(CoordinatesRepository repository, CoordinatesMapper mapper) {
        super(repository, mapper);
    }
}
