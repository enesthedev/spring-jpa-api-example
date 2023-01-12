package com.enesthedev.customer.dto.Customer;

import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
public class CustomerCreateDto {
    private String firstName;
    private String lastName;
    private String telephoneNumber;
    private Date birthDate;
}

