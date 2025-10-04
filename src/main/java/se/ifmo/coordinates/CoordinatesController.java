package se.ifmo.coordinates;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import se.ifmo.common.AbstractCrudController;

@RestController
@RequestMapping("api/v1/coordinates")
public class CoordinatesController extends AbstractCrudController<
        CoordinatesDto,
        Long,
        CoordinatesService
        > {

    public CoordinatesController(CoordinatesService service) {
        super(service);
    }
}
