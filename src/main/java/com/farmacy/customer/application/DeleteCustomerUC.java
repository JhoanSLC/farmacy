package com.farmacy.customer.application;

import com.farmacy.customer.domain.service.CustomerService;

public class DeleteCustomerUC {
    private final CustomerService customerService;

    public DeleteCustomerUC(CustomerService customerService) {
        this.customerService = customerService;
    }

    public void delete(String idCustomer) {
        customerService.deleteCustomer(idCustomer);
    }
}
