package com.code4source.controller;

import com.code4source.ApplicationTest;
import com.code4source.controller.model.ProductWeb;
import com.code4source.domain.entity.Product;
import com.code4source.usecase.CreateProduct;
import com.code4source.usecase.FindProduct;
import com.code4source.usecase.port.ProductRepository;
import com.code4source.uuid.UuidGenerator;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.mockito.Mockito;
import static org.mockito.Mockito.when;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ApplicationTest.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ProductControllerTest {

    @Autowired
    static ProductController instance;

    static UuidGenerator uuidGenerator;

    @MockBean
    ProductRepository productRepository;

    public ProductControllerTest() {
    }

    @BeforeClass
    public static void setUpClass() {
        uuidGenerator = new UuidGenerator();
    }

    @Before
    public void setUp() {
        instance = new ProductController(new CreateProduct(productRepository, new UuidGenerator()), new FindProduct(productRepository));
    }

    /**
     * Test of createProduct method, of class ProductController.
     */
    @Test
    public void testCreateProduct() {
        when(productRepository.create(Mockito.any(Product.class)))
                .thenAnswer(i -> i.getArguments()[0]);

        System.out.println("createProduct");
        ProductWeb productWeb = ProductWeb.toProductWeb(Product.builder()
                .name("Test")
                .price(BigDecimal.ONE)
                .build());
        ProductWeb expResult = productWeb;
        ProductWeb result = instance.createProduct(productWeb);
        assertEquals(expResult.getName(), result.getName());
    }

    /**
     * Test of getProduct method, of class ProductController.
     */
    @Test
    public void testGetProduct() {
        when(productRepository.findById(Mockito.any(UUID.class)))
                .thenAnswer(i -> Optional.of(Product.builder()
                .id((UUID) i.getArguments()[0])
                .name("Test")
                .price(BigDecimal.ONE)
                .build()
        ));

        System.out.println("getProduct");
        UUID productId = uuidGenerator.generate();
        UUID expResult = productId;
        ProductWeb result = instance.getProduct(productId);
        assertEquals(expResult, result.getId());
    }

    /**
     * Test of allProducts method, of class ProductController.
     */
    @Test
    public void testAllProducts() {
        when(productRepository.findAllProducts())
                .thenAnswer(i -> new ArrayList<>(Arrays.asList(Product.builder()
                .id(uuidGenerator.generate())
                .name("Test")
                .price(BigDecimal.ONE)
                .build())
        ));

        System.out.println("allProducts");
        List<ProductWeb> expResult = new ArrayList<>(Arrays.asList(ProductWeb.toProductWeb(Product.builder()
                .name("Test")
                .price(BigDecimal.ONE)
                .build())
        ));
        List<ProductWeb> result = instance.allProducts();
        assertEquals(expResult.size(), result.size());
    }

}
