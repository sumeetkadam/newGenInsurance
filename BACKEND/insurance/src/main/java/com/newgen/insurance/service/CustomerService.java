package com.newgen.insurance.service;


import com.newgen.insurance.entity.CustomerEntity;
import com.newgen.insurance.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    private final CustomerRepository repository;

    public CustomerService(CustomerRepository repository) {
        this.repository = repository;
    }

    public List<CustomerEntity> getAllCustomers() {
        return repository.findAll();
    }

    public CustomerEntity getCustomerById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public CustomerEntity createCustomer(CustomerEntity customer) {
        return repository.save(customer);
    }

    public CustomerEntity updateCustomer(Long id, CustomerEntity customerDetails) {
    	CustomerEntity customer = repository.findById(id).orElse(null);
        if (customer != null) {
            customer.setName(customerDetails.getName());
            customer.setEmail(customerDetails.getEmail());
            return repository.save(customer);
        }
        return null;
    }

    public void deleteCustomer(Long id) {
        repository.deleteById(id);
    }
}

