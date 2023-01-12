package com.enesthedev.customer.services;

import com.enesthedev.customer.entities.Customer;
import com.enesthedev.customer.repositories.CustomerRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;
    private final ModelMapper modelMapper;

    public CustomerServiceImpl(CustomerRepository customerRepository, ModelMapper modelMapper) {
        this.customerRepository = customerRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public Customer create(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Customer update(Customer customer) {
        Customer existing = customerRepository.findById(customer.getId())
                .orElseThrow(() -> new EntityNotFoundException("Customer not found"));
        modelMapper.map(customer, existing);
        return customerRepository.save(existing);
    }

    @Override
    public Customer get(Long id) {
        return customerRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Customer not found"));
    }

    @Override
    public List<Customer> get(String telephoneNumber) {
        return customerRepository.findByTelephoneNumberLike(telephoneNumber);
    }

    @Override
    public List<Customer> get() {
        return customerRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        customerRepository.deleteById(id);
    }
}
