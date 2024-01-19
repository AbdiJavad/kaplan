package com.avin.kaplan.service;

import com.avin.kaplan.model.Product;
import com.avin.kaplan.repository.ProductRepository;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class Productservice {

    @Autowired
    ProductRepository productRepository;

    public Product updateProduct(Long id, Product products) {
        Product product ;
        Optional<Product> productData = productRepository.findById(id);
        if (productData.isPresent()) {
            product = productData.get();
        } else {
            return null;
        }
        if (products.getId() != null && products.getId() > 0) {
            product.setId(products.getId());
        }
        if (products.getName() != null) {
            product.setName(products.getName());
        }
        if(products.getWeight() !=0){
            product.setWeight(products.getWeight());
        }
        if(products.getDateCreated()!=null){
            product.setDateCreated(products.getDateCreated());
        }
       return productRepository.save(product);
    }
}

