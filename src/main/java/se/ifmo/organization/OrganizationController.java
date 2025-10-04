package se.ifmo.organization;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import se.ifmo.common.AbstractCrudController;

@RestController
@RequestMapping("api/v1/organization")
public class OrganizationController extends AbstractCrudController<
        OrganizationDto,
        Integer,
        OrganizationService
        > {

    public OrganizationController(OrganizationService service) {
        super(service);
    }
}
