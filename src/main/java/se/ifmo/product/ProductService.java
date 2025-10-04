package se.ifmo.product;

import org.springframework.stereotype.Service;
import se.ifmo.common.AbstractCrudService;

@Service
public class ProductService extends AbstractCrudService <
        Product,
        ProductRepository,
        ProductDto,
        ProductMapper,
        Integer
        > {

    public ProductService(ProductRepository repository, ProductMapper mapper) {
        super(repository, mapper);
    }
}
