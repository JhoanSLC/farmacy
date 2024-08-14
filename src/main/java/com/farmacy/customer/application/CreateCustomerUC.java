package com.farmacy.customer.application;

import com.farmacy.customer.domain.entity.Customer;
import com.farmacy.customer.domain.service.CustomerService;

public class CreateCustomerUC {
    private final CustomerService customerService;

    public CreateCustomerUC(CustomerService customerService) {
        this.customerService = customerService;
    }

    public void create(Customer customer) {
        customerService.createCustomer(customer);
    }
}
