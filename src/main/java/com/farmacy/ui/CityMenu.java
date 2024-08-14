package com.farmacy.ui;

import com.farmacy.city.infrastructure.controller.CityController;
import com.farmacy.screen.ScreenController;

import java.util.Scanner;

public class CityMenu {
    private final CityController cityController;
    private final Scanner scan = new Scanner(System.in);
    private final ScreenController screen = new ScreenController();
    public CityMenu() {
        this.cityController = new CityController();
    }

    public void display() {
        boolean running = true;
        while (running) {
            screen.clean();
            System.out.printf("+++++++++++++++%n++ City Menu ++%n+++++++++++++++%n");
            System.out.printf("%n1. Create City%n");
            System.out.println("2. Delete City");
            System.out.println("3. Find City by Code");
            System.out.println("4. Update City");
            System.out.println("5. List All Cities");
            System.out.println("6. Return to Main Menu");
            System.out.println("");
            System.out.print("Choose an option: ");
            int option = scan.nextInt();
            scan.nextLine(); 

            switch (option) {
                case 1: 
                    cityController.createCity();
                    break;
                case 2:
                    cityController.deleteCity();
                    break;
                case 3:
                    cityController.findCityById();
                    break;
                case 4:
                    cityController.updateCity();
                    break;
                case 5:
                    cityController.listAllCities();
                    break;
                case 6:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option, please try again.");
                    break;
            }
        }
    }
}
