package se.ifmo.address;

import org.springframework.stereotype.Service;
import se.ifmo.common.AbstractCrudService;

@Service
public class AddressService extends AbstractCrudService<
        Address,
        AddressRepository,
        AddressDto,
        AddressMapper,
        Long
        >{

    public AddressService(AddressRepository repository, AddressMapper mapper) {
        super(repository, mapper);
    }
}
