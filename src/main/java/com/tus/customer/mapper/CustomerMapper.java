package com.tus.customer.mapper;

import com.tus.customer.dto.CustomerDto;
import com.tus.customer.entity.Customer;

public class CustomerMapper {
    public static CustomerDto toDto(Customer entity) {
        return new CustomerDto(entity.getName(), entity.getEmail(), entity.getMobileNumber());
    }

    public static Customer toEntity(CustomerDto dto) {
        Customer c = new Customer();
        c.setName(dto.getName());
        c.setEmail(dto.getEmail());
        c.setMobileNumber(dto.getMobileNumber());
        return c;
    }
}
