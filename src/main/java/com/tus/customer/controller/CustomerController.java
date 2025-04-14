package com.tus.customer.controller;

import com.tus.customer.dto.CustomerDto;
import com.tus.customer.service.CustomerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/customers")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping
    public ResponseEntity<CustomerDto> getCustomerByMobile(@RequestParam String mobile) {
        return ResponseEntity.ok(customerService.getByMobile(mobile));
    }

    @PostMapping
    public ResponseEntity<CustomerDto> addCustomer(@Valid @RequestBody CustomerDto customerDto) {
        return ResponseEntity.ok(customerService.save(customerDto));
    }
}
