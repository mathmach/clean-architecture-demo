package com.code4source.controller.model;

import com.code4source.domain.entity.Product;
import java.math.BigDecimal;
import java.util.UUID;

public class ProductWeb {

    private UUID id;
    private String name;
    private BigDecimal price;

    public static ProductWeb toProductWeb(final Product product) {
        ProductWeb productWeb = new ProductWeb();
        productWeb.setId(product.getId());
        productWeb.setName(product.getName());
        productWeb.setPrice(product.getPrice());
        return productWeb;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Product toProduct() {
        return Product.builder()
                .name(name)
                .price(price)
                .build();
    }
}
