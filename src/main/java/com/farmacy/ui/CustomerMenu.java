package com.farmacy.ui;

import com.farmacy.customer.infrastructure.controller.CustomerController;
import com.farmacy.screen.ScreenController;

import java.util.Scanner;

public class CustomerMenu {
    private final CustomerController customerController;
    private final Scanner sc = new Scanner(System.in);
    private final ScreenController screen = new ScreenController();

    public CustomerMenu() {
        this.customerController = new CustomerController();
    }

    public void customerMenu() {
        boolean isRunning = true;
        while (isRunning) {
            screen.clean();
            System.out.printf("++++++++++++++++++%n++ Customer CRUD ++%n++++++++++++++++++%n");
            System.out.printf("%nType the number of the action you want to perform%n");
            System.out.printf("%n1. Create customer%n2. Find customer by ID%n3. Update customer%n4. Delete customer%n5. List all customers%n6. Return to Main Menu%n");
            System.out.println("");
            System.out.print("Choose an option: ");
            String userOption = sc.nextLine();
            
            switch (userOption) {
                case "1":
                    customerController.createCustomer();
                    break;
                case "2":
                    customerController.findCustomerById();
                    break;
                case "3":
                    customerController.updateCustomer();
                    break;
                case "4":
                    customerController.deleteCustomer();
                    break;
                case "5":
                    customerController.listAllCustomers();
                    break;
                case "6":
                    isRunning = false;
                    break;
                default:
                    screen.clean();
                    System.out.println("Please select a valid option");
                    break;
            }
        }
    }
}
