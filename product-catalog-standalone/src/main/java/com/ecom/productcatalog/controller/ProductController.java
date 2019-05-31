package com.ecom.productcatalog.controller;

import com.ecom.productcatalog.data.Product;
import com.ecom.productcatalog.service.ProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@RestController
public class ProductController {

    @Autowired
    ProductService productService;

    @ApiOperation(value="", hidden = true)
    @RequestMapping("")
    void redirect(HttpServletResponse response) throws IOException {
        response.sendRedirect("swagger-ui.html");;
    }

    @PostMapping("/products/create")
    ResponseEntity<String> createProduct(@RequestParam String productName) {
        Product product = Product.builder().id(UUID.randomUUID().toString()).name(productName).build();
        productService.saveProduct(product);
        return new ResponseEntity<>("Successfully saved product", HttpStatus.CREATED);
    }

    @GetMapping("/products/get")
    ResponseEntity<List<Product>> getProducts()  {
        List<Product> allProducts = productService.findAllProducts();
        if (CollectionUtils.isEmpty(allProducts)) {
            return new ResponseEntity("No Products were found in db", HttpStatus.OK);
        }
        return new ResponseEntity(allProducts, HttpStatus.OK);
    }

    @GetMapping("/products/get/id")
    ResponseEntity<Product> getProductsById(String id)  {
        Product product = productService.findProductById(id);
        if (null == product) {
            return new ResponseEntity("No Product was found with Id: " + id, HttpStatus.OK);
        }
        return new ResponseEntity(product, HttpStatus.OK);
    }

    @PutMapping("/products/update")
    ResponseEntity<List<Product>> updateProductById(String id, String name)  {
        productService.updateProductById(id, name);
        return new ResponseEntity("Successfully updated product with Id: " + id, HttpStatus.OK);
    }

    @DeleteMapping("/products/delete")
    ResponseEntity<List<Product>> deleteAllProducts()  {
        productService.deleteProducts();
        return new ResponseEntity("Successfully deleted all products", HttpStatus.OK);
    }

    @DeleteMapping("/products/delete/id")
    ResponseEntity<List<Product>> deleteProductById(String id)  {
        productService.deleteProductById(id);
        return new ResponseEntity("Successfully deleted product with Id" + id, HttpStatus.OK);
    }
}
