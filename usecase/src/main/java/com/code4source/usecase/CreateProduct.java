package com.code4source.usecase;

import com.code4source.domain.entity.Product;
import com.code4source.usecase.exception.ProductAlreadyExistsException;
import com.code4source.usecase.port.IdGenerator;
import com.code4source.usecase.port.ProductRepository;
import com.code4source.usecase.validator.ProductValidator;

public final class CreateProduct {

    private final ProductRepository repository;
    private final IdGenerator idGenerator;

    public CreateProduct(final ProductRepository repository, final IdGenerator idGenerator) {
        this.repository = repository;
        this.idGenerator = idGenerator;
    }

    public Product create(final Product product) {
        ProductValidator.validateCreateProduct(product);
        if (repository.findByName(product.getName()).isPresent()) {
            throw new ProductAlreadyExistsException(product.getName());
        }
        Product productToSave = Product.builder()
                .id(idGenerator.generate())
                .name(product.getName())
                .price(product.getPrice())
                .build();
        return repository.create(productToSave);
    }
}
