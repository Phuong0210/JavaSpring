package com.spa.spa.products.services;

import com.spa.spa.products.models.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAll();

    Product getProductById(String productId);

    Product createProduct(Product product);

    Product updateProduct(Product productDetails);

    void deleteProduct(String productId);

    List<Product> findProductByUserId(String userId);
}
