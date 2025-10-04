package se.ifmo.person;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import se.ifmo.common.AbstractCrudController;

@RestController
@RequestMapping("api/v1/person")
public class PersonController extends AbstractCrudController<
        PersonDto,
        Long,
        PersonService
        > {
    public PersonController(PersonService service) {
        super(service);
    }
}
