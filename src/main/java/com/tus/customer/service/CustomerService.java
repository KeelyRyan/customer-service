package com.tus.customer.service;

import com.tus.customer.dto.CustomerDto;
import com.tus.customer.entity.Customer;
import com.tus.customer.exception.ResourceNotFoundException;
import com.tus.customer.mapper.CustomerMapper;
import com.tus.customer.repository.CustomerRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerDto getByMobile(String mobile) {
        Customer c = customerRepository.findByMobileNumber(mobile)
                .orElseThrow(() -> new ResourceNotFoundException("Customer", "mobileNumber", mobile));
        return CustomerMapper.toDto(c);
    }

    public CustomerDto save(CustomerDto dto) {
        Customer c = customerRepository.save(CustomerMapper.toEntity(dto));
        return CustomerMapper.toDto(c);
    }
}
