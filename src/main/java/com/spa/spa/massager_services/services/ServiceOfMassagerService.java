package com.spa.spa.massager_services.services;

import com.spa.spa.massager_services.models.ServiceOfMassager;

import java.util.List;

public interface ServiceOfMassagerService {

    List<ServiceOfMassager> getAllServices();

    ServiceOfMassager findById(String serviceId);

    ServiceOfMassager updateService(ServiceOfMassager serviceDetails);

    void deleteService(String serviceId);

    ServiceOfMassager createService(ServiceOfMassager serviceOfMassager);

    List<ServiceOfMassager> findServicesByUserId(String userId);

    List<ServiceOfMassager> findServicesByUserIdAndActive(String userId, boolean active);
}
