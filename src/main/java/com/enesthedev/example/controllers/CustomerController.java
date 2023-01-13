package com.enesthedev.example.controllers;

import com.enesthedev.example.dto.Customer.CustomerCreateDto;
import com.enesthedev.example.dto.Customer.CustomerDto;
import com.enesthedev.example.dto.Customer.CustomerUpdateDto;
import com.enesthedev.example.entities.Customer;
import com.enesthedev.example.services.CustomerService;
import com.enesthedev.example.utils.MapperUtil;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    private final CustomerService customerService;
    private final ModelMapper modelMapper;

    public CustomerController(CustomerService customerService, ModelMapper modelMapper) {
        this.customerService = customerService;
        this.modelMapper = modelMapper;
    }

    @PostMapping
    public ResponseEntity<CustomerDto> create(@RequestBody CustomerCreateDto customerDto) {
        Customer customer = modelMapper.map(customerDto, Customer.class);
        Customer created = customerService.create(customer);
        CustomerDto response = modelMapper.map(created, CustomerDto.class);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<CustomerDto> update(@RequestBody CustomerUpdateDto customerDto) {
        Customer customer = modelMapper.map(customerDto, Customer.class);
        Customer updated = customerService.update(customer);
        CustomerDto response = modelMapper.map(updated, CustomerDto.class);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerDto> get(@PathVariable Long id) {
        Customer customer = customerService.get(id);
        CustomerDto customerDto = modelMapper.map(customer, CustomerDto.class);
        return new ResponseEntity<>(customerDto, HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<List<CustomerDto>> get() {
        List<Customer> customers = customerService.get();
        List<CustomerDto> customerDto = MapperUtil.mapList(customers, CustomerDto.class);
        return new ResponseEntity<>(customerDto, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        customerService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

