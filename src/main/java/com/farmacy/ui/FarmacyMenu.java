package com.farmacy.ui;

import com.farmacy.farmacy.infrastructure.controller.FarmacyController;
import com.farmacy.screen.ScreenController;

import java.util.Scanner;

public class FarmacyMenu {
    private final FarmacyController farmacyController;
    private final Scanner sc = new Scanner(System.in);
    private final ScreenController screen = new ScreenController();

    public FarmacyMenu() {
        this.farmacyController = new FarmacyController();
    }

    public void farmacyMenu() {
        boolean isRunning = true;
        while (isRunning) {
            screen.clean();
            System.out.printf("++++++++++++++++++%n++ Farmacy CRUD ++%n++++++++++++++++++%n");
            System.out.printf("%nType the number of the action you want to perform%n");
            System.out.printf("%n1. Create pharmacy%n2. Find pharmacy by ID%n3. Update pharmacy%n4. Delete pharmacy%n5. List all pharmacies%n6. Return to Main Menu%n");
            System.out.println("");
            System.out.print("Choose an option: ");
            String userOption = sc.nextLine();

            switch (userOption) {
                case "1":
                    farmacyController.createFarmacy();
                    break;
                case "2":
                    farmacyController.findFarmacyById();
                    break;
                case "3":
                    farmacyController.updateFarmacy();
                    break;
                case "4":
                    farmacyController.deleteFarmacy();
                    break;
                case "5":
                    farmacyController.listAllFarmacies();
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
