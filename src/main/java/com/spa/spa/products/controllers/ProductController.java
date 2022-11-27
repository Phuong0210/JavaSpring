package com.spa.spa.products.controllers;

import com.spa.spa.products.models.Product;
import com.spa.spa.products.services.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1")
@CrossOrigin("http://localhost:8080")
@AllArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping("/products")
    public ResponseEntity<List<Product>> getAllProducts(){
        return new ResponseEntity<>(productService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable(value = "id") String productId){
        Product product = productService.getProductById(productId);
        if(product == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @PostMapping("/products")
    public ResponseEntity<Product> createProduct(@RequestBody Product product){
        return new ResponseEntity<>(productService.createProduct(product), HttpStatus.CREATED);
    }

    @PutMapping("/products/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable(value = "id") String productId,
                                                 @RequestBody Product productDetails) {
        Product productOptional = productService.getProductById(productId);
        if (productOptional == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        Product updatedProduct = productService.updateProduct(productDetails);

        return new ResponseEntity<>(updatedProduct, HttpStatus.OK);
    }

    @DeleteMapping("/products/{id}")
    public ResponseEntity<Product> deleteProduct(@PathVariable(value = "id") String productId) {
        Product productOptional = productService.getProductById(productId);
        if (productOptional == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        productService.deleteProduct(productId);
        return new ResponseEntity<>(productOptional, HttpStatus.OK);
    }

    @GetMapping("/products/provider/{userId}")
    public ResponseEntity<List<Product>> getProductByUserId(@PathVariable(value = "userId") String userId){
        List<Product> products = productService.findProductByUserId(userId);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }
}
