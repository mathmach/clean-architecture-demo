package com.code4source.domain.entity;

import java.math.BigDecimal;
import java.util.UUID;

public class Product {

    private final UUID id;
    private final String name;
    private final BigDecimal price;

    private Product(final UUID id, final String name, final BigDecimal price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public static ProductBuilder builder() {
        return new ProductBuilder();
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public static class ProductBuilder {

        private UUID id;
        private String name;
        private BigDecimal price;

        ProductBuilder() {
        }

        public ProductBuilder id(final UUID id) {
            this.id = id;
            return this;
        }

        public ProductBuilder name(final String name) {
            this.name = name;
            return this;
        }

        public ProductBuilder price(final BigDecimal price) {
            this.price = price;
            return this;
        }

        public Product build() {
            return new Product(id, name, price);
        }
    }
}
