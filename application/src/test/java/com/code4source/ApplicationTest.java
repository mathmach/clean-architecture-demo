package com.code4source;

import com.code4source.controller.OrderControllerTest;
import com.code4source.controller.ProductControllerTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {
    OrderControllerTest.class,
    ProductControllerTest.class
})
@ActiveProfiles(profiles = "test")
public class ApplicationTest {

    @Test
    public void contextLoads() {
    }

}
