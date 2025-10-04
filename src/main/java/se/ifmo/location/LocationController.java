package se.ifmo.location;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import se.ifmo.common.AbstractCrudController;

@RestController
@RequestMapping("api/v1/location")
public class LocationController extends AbstractCrudController<
        LocationDto,
        Integer,
        LocationService
        >{

    public LocationController(LocationService service) {
        super(service);
    }
}
