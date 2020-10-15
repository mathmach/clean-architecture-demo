package com.code4source.db.jpa;

import com.code4source.db.jpa.model.ProductDb;
import com.code4source.domain.entity.Product;
import com.code4source.usecase.port.ProductRepository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;

public class JPAProductRepository implements ProductRepository {

    @Autowired
    com.code4source.db.jpa.repository.Product productRepository;

    @Override
    public Product create(final Product product) {
        ProductDb productDb = ProductDb.from(product);
        productDb = productRepository.save(productDb);
        return productDb.toProduct();
    }

    @Override
    public Optional<Product> findById(final UUID id) {
        Optional<ProductDb> productDb = productRepository.findById(id);
        if (productDb.isPresent()) {
            return Optional.of(productDb.get().toProduct());
        }
        return Optional.empty();
    }

    @Override
    public Optional<Product> findByName(final String name) {
        Optional<ProductDb> productDb = productRepository.findByName(name);
        if (productDb.isPresent()) {
            return Optional.of(productDb.get().toProduct());
        }
        return Optional.empty();
    }

    @Override
    public List<Product> findAllProducts() {
        return productRepository.findAll()
                .stream()
                .map(ProductDb::toProduct)
                .collect(Collectors.toList());
    }

}
