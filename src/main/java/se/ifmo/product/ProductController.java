package se.ifmo.product;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import se.ifmo.common.AbstractCrudController;

@RestController
@RequestMapping("api/v1/product")
public class ProductController extends AbstractCrudController<
        ProductDto,
        Integer,
        ProductService
        > {

    public ProductController(ProductService service) {
        super(service);
    }
}
