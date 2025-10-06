package se.ifmo.product;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import se.ifmo.common.AbstractCrudService;

import java.util.Map;
import java.util.Set;

@Service
public class ProductService extends AbstractCrudService <
        Product,
        ProductRepository,
        ProductDto,
        ProductMapper,
        Integer
        > {

    public ProductService(ProductRepository repository, @Qualifier("productMapperImpl") ProductMapper mapper) {
        super(repository, mapper);
    }

    @Override
    public String getEntityName() {
        return "product";
    }

    @Override
    protected Set<String> getAllowedSearchFields() {
        return Set.of("name", "part_number");
    }

    @Override
    protected Map<String, String> getFieldMapping() {
        return Map.of("name", "name", "partNumber", "part_number");
    }
}
