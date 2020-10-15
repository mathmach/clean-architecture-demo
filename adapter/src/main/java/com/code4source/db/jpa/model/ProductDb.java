package com.code4source.db.jpa.model;

import com.code4source.domain.entity.Product;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.UUID;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "product")
public class ProductDb implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private UUID id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "name")
    private String name;
    @Min(value = 0)
    @Basic(optional = false)
    @NotNull
    @Column(name = "price")
    private BigDecimal price;

    public static ProductDb from(final Product product) {
        final ProductDb productDb = new ProductDb();
        productDb.setId(product.getId());
        productDb.setName(product.getName());
        productDb.setPrice(product.getPrice());
        return productDb;
    }

    public UUID getId() {
        return id;
    }

    public void setId(final UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(final BigDecimal price) {
        this.price = price;
    }

    public Product toProduct() {
        return Product.builder()
                .id(id)
                .name(name)
                .price(price)
                .build();
    }
}
