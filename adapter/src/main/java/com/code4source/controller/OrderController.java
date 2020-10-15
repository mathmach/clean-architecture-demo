package com.code4source.controller;

import com.code4source.controller.model.OrderWeb;
import com.code4source.usecase.OrderProducts;
import java.util.List;
import java.util.UUID;

public class OrderController {

    private final OrderProducts orderProducts;

    public OrderController(final OrderProducts orderProducts) {
        this.orderProducts = orderProducts;
    }

    public OrderWeb orderProducts(final List<UUID> productsId) {
        return OrderWeb.toOrderWeb(orderProducts.orderProducts(productsId));
    }

}
