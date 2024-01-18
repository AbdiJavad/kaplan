package com.avin.kaplan.controller;

import com.avin.kaplan.model.Product;
import com.avin.kaplan.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("product")
public class ProductController {

    @Autowired
    public ProductRepository productRepository;

    @GetMapping
    public List<Product> getProduct() {
        return productRepository.findAll();
    }
    @PostMapping
    public Product save(@RequestBody Product product){
        return productRepository.save(product);
    }
}
