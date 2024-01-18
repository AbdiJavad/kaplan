package com.avin.kaplan.controller;

import com.avin.kaplan.model.Product;
import com.avin.kaplan.repository.ProductRepository;
import com.avin.kaplan.service.Productservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("product")
public class ProductController {

    @Autowired
    public ProductRepository productRepository;
    @Autowired
    Productservice productservice;

    @GetMapping
    public List<Product> getProduct() {
        return productRepository.findAll();
    }

    @PostMapping
    public Product save(@RequestBody Product product) {
        return productRepository.save(product);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        productRepository.findById(id);
    }

    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable("id") Long id, @RequestBody Product product) {
        return productservice.updateProduct(id, product);

    }
}