package se.ifmo.address;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import se.ifmo.common.AbstractCrudController;

@RestController
@RequestMapping("api/v1/address")
public class AddressController extends AbstractCrudController<
        AddressDto,
        Integer,
        AddressService
        >{

    public AddressController(AddressService service) {
        super(service);
    }
}
