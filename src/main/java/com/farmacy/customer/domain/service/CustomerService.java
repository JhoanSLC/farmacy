package com.farmacy.customer.domain.service;

import com.farmacy.customer.domain.entity.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerService {
    void createCustomer(Customer customer);
    Optional<Customer> findCustomerById(String idCustomer);
    void updateCustomer(Customer customer);
    void deleteCustomer(String idCustomer);
    List<Customer> listAllCustomers();
}
