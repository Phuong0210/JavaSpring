package com.spa.spa.massager_services.repositories;

import com.spa.spa.massager_services.models.ServiceOfMassager;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ServiceOfMassagerRepository extends MongoRepository<ServiceOfMassager, String> {
    List<ServiceOfMassager> findServiceOfMassagerByActiveIsTrue();

    List<ServiceOfMassager> findServicesByUserIdAndActiveIsTrue(String userId);
}
