package se.ifmo.address;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import se.ifmo.common.AbstractCrudService;

@Service
public class AddressService extends AbstractCrudService<
        Address,
        AddressRepository,
        AddressDto,
        AddressMapper,
        Integer
        >{

    public AddressService(AddressRepository repository, @Qualifier("addressMapperImpl") AddressMapper mapper) {
        super(repository, mapper);
    }
}
