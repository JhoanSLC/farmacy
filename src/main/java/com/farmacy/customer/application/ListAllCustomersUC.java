package com.farmacy.customer.application;

import com.farmacy.customer.domain.entity.Customer;
import com.farmacy.customer.domain.service.CustomerService;

import java.util.List;

public class ListAllCustomersUC {
    private final CustomerService customerService;

    public ListAllCustomersUC(CustomerService customerService) {
        this.customerService = customerService;
    }

    public List<Customer> list() {
        return customerService.listAllCustomers();
    }
}
