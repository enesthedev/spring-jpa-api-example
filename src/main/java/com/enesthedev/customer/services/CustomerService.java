package com.enesthedev.customer.services;

import com.enesthedev.customer.entities.Customer;

import java.util.List;

public interface CustomerService {
    Customer create(Customer customer);

    Customer update(Customer customer);

    Customer get(Long id);

    List<Customer> get(String telephoneNumber);

    List<Customer> get();

    void delete(Long id);
}
