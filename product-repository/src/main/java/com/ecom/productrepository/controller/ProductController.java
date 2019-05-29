package com.ecom.productrepository.controller;

import com.ecom.productrepository.repository.ProductRepository;
import com.ecom.productrepository.data.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;


@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    ProductRepository repository;
    @PostMapping
    ResponseEntity<String> createProduct(Product product) {
        if (null == product.getId()) {
            product.setId(UUID.randomUUID());
        }
        repository.save(product);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
