package com.newgen.insurance.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.newgen.insurance.entity.CustomerEntity;

public interface CustomerRepository extends JpaRepository<CustomerEntity, Long> {
}
