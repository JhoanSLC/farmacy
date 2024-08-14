package com.farmacy.customer.infrastructure.controller;

import com.farmacy.customer.application.*;
import com.farmacy.customer.domain.entity.Customer;
import com.farmacy.customer.domain.service.CustomerService;
import com.farmacy.customer.infrastructure.repository.CustomerRepository;
import com.farmacy.screen.ScreenController;

import java.sql.Date;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class CustomerController {
    private final CustomerService customerService;
    private final CreateCustomerUC createCustomerUC;
    private final DeleteCustomerUC deleteCustomerUC;
    private final FindCustomerByIdUC findCustomerByIdUC;
    private final UpdateCustomerUC updateCustomerUC;
    private final ListAllCustomersUC listAllCustomersUC;
    private final Scanner scan = new Scanner(System.in);
    private final ScreenController screen = new ScreenController();

    public CustomerController() {
        CustomerRepository customerRepository = new CustomerRepository();
        this.customerService = customerRepository;
        this.createCustomerUC = new CreateCustomerUC(customerService);
        this.deleteCustomerUC = new DeleteCustomerUC(customerService);
        this.findCustomerByIdUC = new FindCustomerByIdUC(customerService);
        this.updateCustomerUC = new UpdateCustomerUC(customerService);
        this.listAllCustomersUC = new ListAllCustomersUC(customerService);
    }

    public void createCustomer() {
        screen.clean();
        System.out.println("Create Customer");
        System.out.print("ID Customer: ");
        String idCustomer = scan.nextLine();
        System.out.print("Name: ");
        String nameCustomer = scan.nextLine();
        System.out.print("Last Name: ");
        String lastNameCustomer = scan.nextLine();
        System.out.print("City Code: ");
        String codeCityCustomer = scan.nextLine();
        System.out.print("Email: ");
        String emailCustomer = scan.nextLine();
        System.out.print("Birth Date (YYYY-MM-DD): ");
        String birthDateStr = scan.nextLine();
        Date birthDate = Date.valueOf(birthDateStr);
        System.out.print("Longitude: ");
        double lon = scan.nextDouble();
        System.out.print("Latitude: ");
        double latitud = scan.nextDouble();
        scan.nextLine();  // Consume the newline

        Customer customer = new Customer(idCustomer, nameCustomer, lastNameCustomer, codeCityCustomer, emailCustomer, birthDate, lon, latitud);
        createCustomerUC.create(customer);
        screen.pause();
    }

    public void findCustomerById() {
        screen.clean();
        System.out.println("Find Customer by ID");
        System.out.print("ID Customer: ");
        String idCustomer = scan.nextLine();
        Optional<Customer> customer = findCustomerByIdUC.findById(idCustomer);
        if (customer.isPresent()) {
            Customer c = customer.get();
            System.out.printf("ID: %s%n", c.getIdCustomer());
            System.out.printf("Name: %s%n", c.getNameCustomer());
            System.out.printf("Last Name: %s%n", c.getLastNameCustomer());
            System.out.printf("City Code: %s%n", c.getCodeCityCustomer());
            System.out.printf("Email: %s%n", c.getEmailCustomer());
            System.out.printf("Birth Date: %s%n", c.getBirthDate());
            System.out.printf("Longitude: %f%n", c.getLon());
            System.out.printf("Latitude: %f%n", c.getLatitud());
        } else {
            System.out.println("Customer not found.");
        }
        screen.pause();
    }

    public void updateCustomer() {
        screen.clean();
        System.out.println("Update Customer");
        System.out.print("ID Customer: ");
        String idCustomer = scan.nextLine();
        System.out.print("New Name: ");
        String nameCustomer = scan.nextLine();
        System.out.print("New Last Name: ");
        String lastNameCustomer = scan.nextLine();
        System.out.print("New City Code: ");
        String codeCityCustomer = scan.nextLine();
        System.out.print("New Email: ");
        String emailCustomer = scan.nextLine();
        System.out.print("New Birth Date (YYYY-MM-DD): ");
        String birthDateStr = scan.nextLine();
        Date birthDate = Date.valueOf(birthDateStr);
        System.out.print("New Longitude: ");
        double lon = scan.nextDouble();
        System.out.print("New Latitude: ");
        double latitud = scan.nextDouble();
        scan.nextLine();  // Consume the newline

        Customer customer = new Customer(idCustomer, nameCustomer, lastNameCustomer, codeCityCustomer, emailCustomer, birthDate, lon, latitud);
        updateCustomerUC.update(customer);
        screen.pause();
    }

    public void deleteCustomer() {
        screen.clean();
        System.out.println("Delete Customer");
        System.out.print("ID Customer: ");
        String idCustomer = scan.nextLine();
        deleteCustomerUC.delete(idCustomer);
        screen.pause();
    }

    public void listAllCustomers() {
        screen.clean();
        System.out.println("List All Customers");
        List<Customer> customers = listAllCustomersUC.list();
        for (Customer customer : customers) {
            System.out.printf("ID: %s%n", customer.getIdCustomer());
            System.out.printf("Name: %s%n", customer.getNameCustomer());
            System.out.printf("Last Name: %s%n", customer.getLastNameCustomer());
            System.out.printf("City Code: %s%n", customer.getCodeCityCustomer());
            System.out.printf("Email: %s%n", customer.getEmailCustomer());
            System.out.printf("Birth Date: %s%n", customer.getBirthDate());
            System.out.printf("Longitude: %f%n", customer.getLon());
            System.out.printf("Latitude: %f%n", customer.getLatitud());
            System.out.println("---------------------------");
        }
        screen.pause();
    }
}
