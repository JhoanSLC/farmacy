package com.farmacy.ui;

import com.farmacy.farmacyMedicine.infrastructure.controller.FarmacyMedicineController;
import com.farmacy.screen.ScreenController;

import java.util.Scanner;

public class FarmacyMedicineMenu {
    private final FarmacyMedicineController farmacyMedicineController;
    private final Scanner sc = new Scanner(System.in);
    private final ScreenController screen = new ScreenController();

    public FarmacyMedicineMenu() {
        this.farmacyMedicineController = new FarmacyMedicineController();
    }

    public void farmacyMedicineMenu() {
        boolean isRunning = true;
        while (isRunning) {
            screen.clean();
            System.out.printf("+++++++++++++++++++++++++%n++ Farmacy Medicine CRUD ++%n+++++++++++++++++++++++++%n");
            System.out.printf("%nType the number of the action you want to perform%n");
            System.out.printf("%n1. Create farmacy medicine entry%n2. Find farmacy medicine by ID%n3. Update farmacy medicine%n4. Delete farmacy medicine%n5. List all farmacy medicines%n6. Return to Main Menu%n");
            System.out.println("");
            System.out.print("Choose an option: ");
            String userOption = sc.nextLine();
            
            switch (userOption) {
                case "1":
                    farmacyMedicineController.createFarmacyMedicine();
                    break;
                case "2":
                    farmacyMedicineController.findFarmacyMedicineById();
                    break;
                case "3":
                    farmacyMedicineController.updateFarmacyMedicine();
                    break;
                case "4":
                    farmacyMedicineController.deleteFarmacyMedicine();
                    break;
                case "5":
                    farmacyMedicineController.listAllFarmacyMedicines();
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
