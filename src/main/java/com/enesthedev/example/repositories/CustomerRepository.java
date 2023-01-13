package com.enesthedev.example.repositories;

import com.enesthedev.example.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    List<Customer> findByTelephoneNumberLike(String telephoneNumber);
}