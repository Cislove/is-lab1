package se.ifmo.product;

import org.mapstruct.Mapper;
import se.ifmo.common.GenericMapper;

@Mapper(componentModel = "spring")
public interface ProductMapper extends GenericMapper<ProductDto, Product> {
}
