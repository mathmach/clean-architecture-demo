package com.code4source.spring.controller;

import com.code4source.controller.OrderController;
import com.code4source.controller.model.OrderWeb;
import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class SpringOrderController {

    private final OrderController controller;

    @Autowired
    public SpringOrderController(final OrderController controller) {
        this.controller = controller;
    }

    @RequestMapping(value = "/order", method = RequestMethod.GET)
    public OrderWeb orderProducts(@RequestParam final List<UUID> productsId) {
        return controller.orderProducts(productsId);
    }
}
