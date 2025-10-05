package se.ifmo.product;

import org.springframework.beans.factory.annotation.Qualifier;
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

    public ProductService(ProductRepository repository, @Qualifier("productMapperImpl") ProductMapper mapper) {
        super(repository, mapper);
    }

    @Override
    public String getEntityName() {
        return "product";
    }
}
