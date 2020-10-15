package com.code4source.controller;

import com.code4source.ApplicationTest;
import com.code4source.controller.model.OrderWeb;
import com.code4source.domain.entity.Product;
import com.code4source.usecase.OrderProducts;
import com.code4source.usecase.port.ProductRepository;
import com.code4source.uuid.UuidGenerator;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.junit.Before;
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
public class OrderControllerTest {

    @Autowired
    static OrderController instance;

    @MockBean
    ProductRepository productRepository;

    public OrderControllerTest() {
    }

    @Before
    public void setUp() {
        instance = new OrderController(new OrderProducts(productRepository));
    }

    /**
     * Test of orderProducts method, of class OrderController.
     */
    @Test
    public void testOrderProducts() {
        when(productRepository.findById(Mockito.any(UUID.class)))
                .thenAnswer(i -> Optional.of(Product.builder()
                .id((UUID) i.getArguments()[0])
                .name("Test")
                .price(BigDecimal.ONE)
                .build()
        ));

        System.out.println("orderProducts");
        List<UUID> productsId = new ArrayList<>(Arrays.asList(new UuidGenerator().generate()));
        BigDecimal expResult = BigDecimal.ONE;
        OrderWeb result = instance.orderProducts(productsId);
        assertEquals(expResult.intValue(), result.getProducts().iterator().next().getPrice().intValue());
    }

}
