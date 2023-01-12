package com.enesthedev.customer.repositories;

import com.enesthedev.customer.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    List<Customer> findByTelephoneNumberLike(String telephoneNumber);
}