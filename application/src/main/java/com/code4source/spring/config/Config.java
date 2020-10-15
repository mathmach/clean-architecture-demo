package com.code4source.spring.config;

import com.code4source.controller.OrderController;
import com.code4source.controller.ProductController;
import com.code4source.db.jpa.JPAProductRepository;
import com.code4source.usecase.CreateProduct;
import com.code4source.usecase.FindProduct;
import com.code4source.usecase.OrderProducts;
import com.code4source.usecase.port.ProductRepository;
import com.code4source.uuid.UuidGenerator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@EntityScan("com.code4source.db.jpa.model")
@EnableJpaRepositories("com.code4source.db.jpa.repository")
public class Config {

    @Autowired
    private ProductRepository productRepository;

    @Bean
    public ObjectMapper objectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        return objectMapper;
    }

    @Bean
    public ProductRepository productRepository() {
        return new JPAProductRepository();
    }

    @Bean
    public CreateProduct createProduct() {
        return new CreateProduct(productRepository, new UuidGenerator());
    }

    @Bean
    public FindProduct findProduct() {
        return new FindProduct(productRepository);
    }

    @Bean
    public OrderProducts orderProducts() {
        return new OrderProducts(productRepository);
    }

    @Bean
    public ProductController productController() {
        return new ProductController(createProduct(), findProduct());
    }

    @Bean
    public OrderController orderController() {
        return new OrderController(orderProducts());
    }

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();
    }
}
