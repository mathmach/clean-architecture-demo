package com.code4source.controller.model;

import com.code4source.domain.entity.Order;
import com.code4source.domain.entity.Product;
import java.math.BigDecimal;
import java.text.MessageFormat;
import java.util.Set;

public class OrderWeb {

    private Set<Product> products;
    private String comission;
    private String discount;
    private BigDecimal total;

    public static OrderWeb toOrderWeb(final Order order) {
        OrderWeb orderWeb = new OrderWeb();
        orderWeb.setProducts(order.getProducts());
        orderWeb.setComission(MessageFormat.format("{0}%", order.getComission() * 100));
        orderWeb.setDiscount(MessageFormat.format("{0}%", order.getDiscount() * 100));
        orderWeb.setTotal(order.getTotal());
        return orderWeb;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    public String getCommission() {
        return comission;
    }

    public void setComission(String comission) {
        this.comission = comission;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public Order toOrder() {
        return Order.builder()
                .products(products)
                .comission(Double.valueOf(comission))
                .discount(Double.valueOf(discount))
                .total(total)
                .build();
    }
}
