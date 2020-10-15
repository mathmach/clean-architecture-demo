package com.code4source.usecase.validator;

import com.code4source.domain.entity.Product;
import com.code4source.usecase.exception.ProductValidationException;
import java.math.BigDecimal;
import static org.apache.commons.lang3.StringUtils.isBlank;

public class ProductValidator {

    private ProductValidator() {

    }

    public static void validateCreateProduct(final Product product) {
        if (product == null) {
            throw new ProductValidationException("Product should not be null");
        }
        if (isBlank(product.getName())) {
            throw new ProductValidationException("Name should not be null");
        }
        if (product.getPrice().compareTo(BigDecimal.ZERO) <= 0) {
            throw new ProductValidationException("Price should not be less than 0");
        }
    }
}
