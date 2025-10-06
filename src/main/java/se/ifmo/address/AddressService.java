package se.ifmo.address;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import se.ifmo.common.AbstractCrudService;

import java.util.Map;
import java.util.Set;

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

    @Override
    public String getEntityName() {
        return "address";
    }

    @Override
    protected Set<String> getAllowedSearchFields() {
        return Set.of("street", "zipCode");
    }

    @Override
    protected Map<String, String> getFieldMapping() {
        return Map.of("street", "street", "zipCode", "zipCode");
    }
}
