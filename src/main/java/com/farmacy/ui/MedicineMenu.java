package com.farmacy.ui;

import com.farmacy.medicine.infrastructure.controller.MedicineController;
import com.farmacy.screen.ScreenController;

import java.util.Scanner;

public class MedicineMenu {
    private final MedicineController medicineController;
    private final Scanner sc = new Scanner(System.in);
    private final ScreenController screen = new ScreenController();

    public MedicineMenu() {
        this.medicineController = new MedicineController();
    }

    public void medicineMenu() {
        boolean isRunning = true;
        while (isRunning) {
            screen.clean();
            System.out.printf("++++++++++++++++++%n++ Medicine CRUD ++%n++++++++++++++++++%n");
            System.out.printf("%nType the number of the action you want to perform%n");
            System.out.printf("%n1. Create medicine%n2. Find medicine by ID%n3. Update medicine%n4. Delete medicine%n5. List all medicines%n6. Return to Main Menu%n");
            System.out.println("");
            System.out.print("Choose an option: ");
            String userOption = sc.nextLine();
            
            switch (userOption) {
                case "1":
                    medicineController.createMedicine();
                    break;
                case "2":
                    medicineController.findMedicineById();
                    break;
                case "3":
                    medicineController.updateMedicine();
                    break;
                case "4":
                    medicineController.deleteMedicine();
                    break;
                case "5":
                    medicineController.listAllMedicines();
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
