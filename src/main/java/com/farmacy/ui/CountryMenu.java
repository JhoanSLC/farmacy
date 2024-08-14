package com.farmacy.ui;

import com.farmacy.country.infrastructure.controller.CountryController;
import com.farmacy.screen.ScreenController;

import java.util.Scanner;

public class CountryMenu {
    private final CountryController countryController;
    private final Scanner sc = new Scanner(System.in);
    private final ScreenController screen = new ScreenController();

    public CountryMenu() {
        this.countryController = new CountryController();
    }

    public void countryMenu() {
        boolean isRunning = true;
        while (isRunning) {
            screen.clean();
            System.out.printf("+++++++++++++++++++++++++%n++ Country CRUD ++%n+++++++++++++++++++++++++%n");
            System.out.printf("%nType the number of the action you want to perform%n");
            System.out.printf("%n1. Create country%n2. Find country by code%n3. Update country%n4. Delete country%n5. List all countries%n6. Return to Main Menu%n");
            String userOption = sc.nextLine();
            
            switch (userOption) {
                case "1":
                    countryController.createCountry();
                    break;
                case "2":
                    countryController.findCountryById();
                    break;
                case "3":
                    countryController.updateCountry();
                    break;
                case "4":
                    countryController.deleteCountry();
                    break;
                case "5":
                    countryController.listAllCountries();
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
