package com.code4source.controller;

import com.code4source.controller.model.ProductWeb;
import com.code4source.domain.entity.Product;
import com.code4source.usecase.CreateProduct;
import com.code4source.usecase.FindProduct;
import com.code4source.usecase.exception.ProductNotFoundException;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class ProductController {

    private final CreateProduct createProduct;
    private final FindProduct findProduct;

    public ProductController(final CreateProduct createProduct, final FindProduct findProduct) {
        this.createProduct = createProduct;
        this.findProduct = findProduct;
    }

    public ProductWeb createProduct(final ProductWeb productWeb) {
        Product product = productWeb.toProduct();
        return ProductWeb.toProductWeb(createProduct.create(product));
    }

    public ProductWeb getProduct(final UUID productId) {
        return ProductWeb.toProductWeb(findProduct.findById(productId).orElseThrow(() -> new ProductNotFoundException("product not found")));
    }

    public List<ProductWeb> allProducts() {
        return findProduct.findAllProducts()
                .stream()
                .map(ProductWeb::toProductWeb)
                .collect(Collectors.toList());
    }
}
