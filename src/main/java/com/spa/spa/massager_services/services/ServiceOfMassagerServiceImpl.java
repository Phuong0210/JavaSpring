package com.spa.spa.massager_services.services;

import com.spa.spa.massager_services.models.ServiceOfMassager;
import com.spa.spa.massager_services.repositories.ServiceOfMassagerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ServiceOfMassagerServiceImpl implements ServiceOfMassagerService {
    private final ServiceOfMassagerRepository serviceOfMassagerRepository;

    @Override
    public List<ServiceOfMassager> getAllServices() {
        return serviceOfMassagerRepository.findServiceOfMassagerByActiveIsTrue();
    }

    @Override
    public ServiceOfMassager findById(String serviceId) {
        return serviceOfMassagerRepository.findById(serviceId).orElse(null);
    }

    @Override
    public ServiceOfMassager updateService(ServiceOfMassager serviceDetails) {
        return serviceOfMassagerRepository.save(serviceDetails);
    }

    @Override
    public void deleteService(String serviceId) {
        ServiceOfMassager service = findById(serviceId);
        service.setActive(false);
        serviceOfMassagerRepository.save(service);
    }

    @Override
    public ServiceOfMassager createService(ServiceOfMassager serviceOfMassager) {
        return serviceOfMassagerRepository.save(serviceOfMassager);
    }

    @Override
    public List<ServiceOfMassager> findServicesByUserId(String userId) {
        return serviceOfMassagerRepository.findServiceOfMassagerByActiveIsTrue();
    }

    @Override
    public List<ServiceOfMassager> findServicesByUserIdAndActive(String userId, boolean active) {
        return serviceOfMassagerRepository.findServicesByUserIdAndActiveIsTrue(userId);
    }


}