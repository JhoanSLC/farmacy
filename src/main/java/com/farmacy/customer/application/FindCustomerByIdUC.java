package com.farmacy.customer.application;

import com.farmacy.customer.domain.entity.Customer;
import com.farmacy.customer.domain.service.CustomerService;

import java.util.Optional;

public class FindCustomerByIdUC {
    private final CustomerService customerService;

    public FindCustomerByIdUC(CustomerService customerService) {
        this.customerService = customerService;
    }

    public Optional<Customer> findById(String idCustomer) {
        return customerService.findCustomerById(idCustomer);
    }
}
