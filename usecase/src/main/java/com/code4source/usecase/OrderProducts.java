package com.code4source.usecase;

import com.code4source.domain.entity.Order;
import com.code4source.domain.entity.Product;
import com.code4source.usecase.exception.ProductNotFoundException;
import com.code4source.usecase.port.ProductRepository;
import java.math.BigDecimal;
import java.text.MessageFormat;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

public final class OrderProducts {

    private final ProductRepository repository;

    public OrderProducts(final ProductRepository repository) {
        this.repository = repository;
    }

    public Order orderProducts(final List<UUID> ids) {
        Set<Product> products = new HashSet<>();
        Double comission = 1.05;
        Double profit = 0.4;
        BigDecimal sum = BigDecimal.ZERO;
        for (UUID id : ids) {
            Optional<Product> product = repository.findById(id);
            if (!product.isPresent()) {
                throw new ProductNotFoundException(MessageFormat.format("product id {0} not found", id));
            }
            products.add(product.get());
            sum = sum.add(product.get().getPrice());
        }
        if (sum.compareTo(new BigDecimal(5000)) >= 0) {
            profit -= 0.1;
        }
        BigDecimal total = new BigDecimal((sum.doubleValue() * comission) + (sum.doubleValue() * profit));
        return Order.builder()
                .products(products)
                .comission(comission - 1)
                .discount(0.4 - profit)
                .total(total)
                .build();
    }
}
