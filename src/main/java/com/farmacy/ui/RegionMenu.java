package com.farmacy.ui;

import com.farmacy.region.infrastructure.controller.RegionController;
import java.util.Scanner;
import com.farmacy.screen.ScreenController;

public class RegionMenu {
    private final RegionController regionController;
    private final ScreenController screen = new ScreenController();
    private final Scanner scan = new Scanner(System.in);

    public RegionMenu() {
        this.regionController = new RegionController();
    }

    public void regionMenu() {
        boolean isRunning = true;
        while (isRunning) {
            screen.clean();
            System.out.printf("++++++++++++++++++++++%n++ Region CRUD Menu ++%n++++++++++++++++++++++%n");
            System.out.printf("%nType the number of the action you want to perform%n");
            System.out.printf("%n1. Create Region%n2. Find Region by Code%n3. Update Region%n4. Delete Region%n5. List All Regions%n6. Return to Main Menu%n");
            System.out.println("");
            System.out.print("Choose an option: ");
            if (scan.hasNextLine()) {
                String userOption = scan.nextLine();

                // Debugging message
                System.out.println("User selected: " + userOption);

                switch (userOption) {
                    case "1":
                        regionController.createRegion();
                        break;
                    case "2":
                        regionController.findRegionById();
                        break;
                    case "3":
                        regionController.updateRegion();
                        break;
                    case "4":
                        regionController.deleteRegion();
                        break;
                    case "5":
                        regionController.listAllRegions();
                        break;
                    case "6":
                        isRunning = false;
                        break;
                    default:
                        screen.clean();
                        System.out.println("Please select a valid option");
                        break;
                }
            } else {
                System.out.println("No input found. Please try again.");
                scan.next(); // Consume the invalid input
            }
        }
    }
}
