package com.springCloud.springCloud.Controller;

import com.springCloud.springCloud.Entity.Product;
import com.springCloud.springCloud.Exception.ProductNotFoundException;
import com.springCloud.springCloud.Service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@Slf4j
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;

    @Autowired
    private ProductController(ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<Product> getAllProduct() {
        return productService.findAllProduct();
    }

    @RequestMapping(value = "/{code}", method = RequestMethod.GET)
    public Product findProductByCode(@PathVariable String code) {
        return productService.findProductByCode(code)
                             .orElseThrow(
                                     () -> new ProductNotFoundException("Product with " + code + " doesn't exist"));
    }
}
