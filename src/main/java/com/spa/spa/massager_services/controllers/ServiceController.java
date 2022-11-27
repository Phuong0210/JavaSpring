package com.spa.spa.massager_services.controllers;

import com.spa.spa.massager_services.models.ServiceOfMassager;
import com.spa.spa.massager_services.services.ServiceOfMassagerService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/services")
@CrossOrigin("http://localhost:8080")
@AllArgsConstructor
public class ServiceController {
    private final ServiceOfMassagerService serviceOfMassagerService;

    @GetMapping("")
    public ResponseEntity<List<ServiceOfMassager>> getAllServices() {
        List<ServiceOfMassager> allServices = serviceOfMassagerService.getAllServices();
        return new ResponseEntity<>(allServices, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ServiceOfMassager> findById(@PathVariable(value = "id") String serviceId) {
        ServiceOfMassager service = serviceOfMassagerService.findById(serviceId);
        if (service == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(service, HttpStatus.OK);
    }

    @PostMapping("/insert")
    public ResponseEntity<ServiceOfMassager> createService(@RequestBody ServiceOfMassager serviceOfMassager) {
        return new ResponseEntity<>(serviceOfMassagerService.createService(serviceOfMassager), HttpStatus.CREATED);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<ServiceOfMassager> updateService(@PathVariable(value = "id") String serviceId,
                                                           @RequestBody ServiceOfMassager serviceDetails) {
        ServiceOfMassager service = serviceOfMassagerService.findById(serviceId);
        if (service == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        ServiceOfMassager updateService = serviceOfMassagerService.updateService(serviceDetails);
        return new ResponseEntity<>(updateService, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ServiceOfMassager> deleteService(@PathVariable(value = "id") String serviceId) {
        ServiceOfMassager service = serviceOfMassagerService.findById(serviceId);
        if (service == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        serviceOfMassagerService.deleteService(serviceId);
        return new ResponseEntity<>(service, HttpStatus.OK);
    }

    @GetMapping("/massager/{userId}")
    public ResponseEntity<List<ServiceOfMassager>> findServicesByUserIdAndActive(@PathVariable(value="userId") String userId, boolean active){
      List<ServiceOfMassager> serviceOfMassager =  serviceOfMassagerService.findServicesByUserIdAndActive(userId,active);
      if (serviceOfMassager == null){
          return new ResponseEntity<>(HttpStatus.NOT_FOUND);
      }
        return new ResponseEntity<>(serviceOfMassager, HttpStatus.OK);
    }


}
