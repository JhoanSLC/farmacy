package com.farmacy.customer.application;

import com.farmacy.customer.domain.entity.Customer;
import com.farmacy.customer.domain.service.CustomerService;

public class UpdateCustomerUC {
    private final CustomerService customerService;

    public UpdateCustomerUC(CustomerService customerService) {
        this.customerService = customerService;
    }

    public void update(Customer customer) {
        customerService.updateCustomer(customer);
    }
}
