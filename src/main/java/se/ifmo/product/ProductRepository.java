package se.ifmo.product;

import org.springframework.stereotype.Repository;
import se.ifmo.common.placemark.AbstractRepository;

@Repository
public interface ProductRepository extends AbstractRepository<Product, Integer> {

}
