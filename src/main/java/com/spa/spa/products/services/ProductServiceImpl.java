package com.spa.spa.products.services;

import com.spa.spa.products.models.Product;
import com.spa.spa.products.repositories.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Product getProductById(String productId){
        return productRepository.getProductById(productId);
    }

    @Override
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product updateProduct(Product productDetails) {
        return productRepository.save(productDetails);
    }

    @Override
    public void deleteProduct(String productId){
        Product product = getProductById(productId);
        product.setActive(false);
        productRepository.save(product);
    }

    @Override
    public List<Product> findProductByUserId(String userId) {
        return productRepository.findProductByUserId(userId);
    }
}
