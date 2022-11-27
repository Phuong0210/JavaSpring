package com.spa.spa.products.repositories;

import com.spa.spa.products.models.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ProductRepository extends MongoRepository<Product, String> {
    Product getProductById(String productId);

    List<Product> findProductByUserId(String userId);
}
