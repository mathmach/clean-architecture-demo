package com.code4source.usecase.port;

import com.code4source.domain.entity.Product;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ProductRepository {

    Product create(Product product);

    Optional<Product> findById(UUID id);

    Optional<Product> findByName(String name);

    List<Product> findAllProducts();

}
