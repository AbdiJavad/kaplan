package com.avin.kaplan.controller;

import com.avin.kaplan.model.Product;
import com.avin.kaplan.repository.ProductRepository;
import com.avin.kaplan.service.Productservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("product")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private Productservice productservice;

    @GetMapping
    public List<Product> getProduct() {
        return productRepository.findAll();
    }

    @GetMapping("{id}")
    public Product findByProductId(@PathVariable("id") Long id){
        Product product = new Product();
        Optional<Product> productData = productRepository.findById(id);
        if (productData.isPresent()){
            product = productData.get();
        }
        return product;
    }

    @PostMapping
    public Product save(@RequestBody Product product) {
        return productRepository.save(product);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        productRepository.deleteById(id);
    }

    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable("id") Long id, @RequestBody Product product) {
        return productservice.updateProduct(id, product);
    }
}
