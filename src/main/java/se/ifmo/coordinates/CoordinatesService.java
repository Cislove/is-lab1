package se.ifmo.coordinates;

import org.springframework.stereotype.Service;
import se.ifmo.common.AbstractCrudService;

@Service
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
