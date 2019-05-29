package com.ecom.productcatalog.controller;

import com.ecom.productcatalog.data.Product;
import com.ecom.productcatalog.exception.CustomException;
import com.ecom.productcatalog.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    ProductRepository repository;

    @GetMapping
    ResponseEntity<List<Product>> getProducts() throws CustomException {
        //Iterable<Product> iterableList = repository.findAll();
        return new ResponseEntity(repository.findAll(), HttpStatus.OK);

    }
}
