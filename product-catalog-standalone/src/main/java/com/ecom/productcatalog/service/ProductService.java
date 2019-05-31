package com.ecom.productcatalog.service;


import com.ecom.productcatalog.data.Product;
import com.ecom.productcatalog.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ProductService {

    @Autowired
    ProductRepository repository;

    public List<Product> findAllProducts() {
        return (List<Product>) repository.findAll();
    }

    public Product findProductById(String id) {
        return repository.findById(id).get();
    }

    public void deleteProductById(String id) {
        repository.deleteById(id);
    }

    public void deleteProducts() {
        repository.deleteAll();
    }

    public void updateProductById(String id, String productName) {
        Product product = Product.builder().id(id).name(productName).build();
        repository.save(product);
    }

    public void saveProduct(Product product) {
        repository.save(product);
    }
}
