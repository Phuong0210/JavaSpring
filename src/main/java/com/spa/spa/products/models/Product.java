package com.spa.spa.products.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "products")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Product {
    @Id
    private String id;
    private String productName;
    private String image;
    private Double price;
    private String userId;
    private boolean active;
}
