package com.code4source.usecase;

import com.code4source.domain.entity.Product;
import com.code4source.usecase.port.ProductRepository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public final class FindProduct {

    private final ProductRepository repository;

    public FindProduct(final ProductRepository repository) {
        this.repository = repository;
    }

    public Optional<Product> findById(final UUID id) {
        return repository.findById(id);
    }

    public List<Product> findAllProducts() {
        return repository.findAllProducts();
    }
}
