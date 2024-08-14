package com.farmacy.customer.domain.service;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import com.farmacy.customer.domain.entity.Customer;

public interface CustomerService {
    void createCustomer(Customer customer);
    Optional<Customer> findCustomerById(long id);
    void updateCustomer(String id, String name, String lastName, String codeCity, String email, Date birthDate, double lon, double latitud);
    void deleteCustomer(long id);
    List<Customer> listAllCustomers();
}
