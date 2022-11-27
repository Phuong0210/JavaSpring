package com.spa.spa.massager_services.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "services")
@NoArgsConstructor
@Data
public class ServiceOfMassager {
    @Id
    private String id;

    private String name;

    private String image;

    private Double price;

    private String description;

    private String userId;

    private boolean active;

}
