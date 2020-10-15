package com.code4source.spring.controller;

import com.code4source.controller.ProductController;
import com.code4source.controller.model.ProductWeb;
import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class SpringProductController {

    private final ProductController controller;

    @Autowired
    public SpringProductController(final ProductController controller) {
        this.controller = controller;
    }

    @RequestMapping(value = "/product", method = RequestMethod.POST)
    public ProductWeb createProduct(@RequestBody final ProductWeb productWeb) {
        return controller.createProduct(productWeb);
    }

    @RequestMapping(value = "/product/{productId}", method = RequestMethod.GET)
    public ProductWeb getProduct(@PathVariable("productId") final UUID productId) {
        return controller.getProduct(productId);
    }

    @RequestMapping(value = "/products", method = RequestMethod.GET)
    public List<ProductWeb> allProducts() {
        return controller.allProducts();
    }
}
