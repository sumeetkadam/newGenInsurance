package com.newgen.insurance.controller;


import com.newgen.insurance.entity.CustomerEntity;
import com.newgen.insurance.service.CustomerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {
    private final CustomerService service;

    public CustomerController(CustomerService service) {
        this.service = service;
    }

    @GetMapping
    public List<CustomerEntity> getAllCustomers() {
        return service.getAllCustomers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerEntity> getCustomerById(@PathVariable Long id) {
    	CustomerEntity customer = service.getCustomerById(id);
        return customer != null ? ResponseEntity.ok(customer) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public CustomerEntity createCustomer(@RequestBody CustomerEntity customer) {
        return service.createCustomer(customer);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CustomerEntity> updateCustomer(@PathVariable Long id, @RequestBody CustomerEntity customerDetails) {
    	CustomerEntity updatedCustomer = service.updateCustomer(id, customerDetails);
        return updatedCustomer != null ? ResponseEntity.ok(updatedCustomer) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable Long id) {
        service.deleteCustomer(id);
        return ResponseEntity.noContent().build();
    }
}

