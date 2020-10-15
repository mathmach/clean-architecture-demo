package com.code4source.domain.entity;

import java.math.BigDecimal;
import java.util.Set;

public class Order {

    private final Set<Product> products;
    private final Double comission;
    private final Double discount;
    private final BigDecimal total;

    private Order(final Set<Product> products, final Double comission, final Double discount, final BigDecimal total) {
        this.products = products;
        this.comission = comission;
        this.discount = discount;
        this.total = total;
    }

    public static OrderBuilder builder() {
        return new OrderBuilder();
    }

    public Set<Product> getProducts() {
        return products;
    }

    public Double getComission() {
        return comission;
    }

    public Double getDiscount() {
        return discount;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public static class OrderBuilder {

        private Set<Product> products;
        private Double comission;
        private Double discount;
        private BigDecimal total;

        OrderBuilder() {
        }

        public OrderBuilder products(final Set<Product> products) {
            this.products = products;
            return this;
        }

        public OrderBuilder comission(final Double comission) {
            this.comission = comission;
            return this;
        }

        public OrderBuilder discount(final Double discount) {
            this.discount = discount;
            return this;
        }

        public OrderBuilder total(final BigDecimal total) {
            this.total = total;
            return this;
        }

        public Order build() {
            return new Order(products, comission, discount, total);
        }
    }
}
