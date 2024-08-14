package com.farmacy.ui;

import com.farmacy.screen.ScreenController;
import com.farmacy.unitMeasurement.infrastructure.controller.UnitMeController;
import java.util.Scanner;

public class UnitMeasurementMenu {
    private final UnitMeController unitMeController;
    private final ScreenController screen = new ScreenController();
    private final Scanner sc = new Scanner(System.in); // Mueve el Scanner fuera del bucle

    public UnitMeasurementMenu() {
        this.unitMeController = new UnitMeController();
    }

    public void unitMeasurementMenu() {
        boolean isRunning = true;
        while (isRunning) {
            screen.clean();
            System.out.printf("++++++++++++++++++++++++++%n++ Unit Measurement CRUD ++%n++++++++++++++++++++++++++%n");
            System.out.printf("%nType the number of the action you want to perform%n");
            System.out.printf("%n1. Create unitMeasurement%n2. Find unitMeasurement by ID%n3. Update unitMeasurement%n4. Delete unitMeasurement%n5. List all unitMeasurement%n6. Return to Main Menu%n");
            System.out.println("");
            System.out.print("Choose an option: ");
            String userOption = sc.nextLine(); // Usa el mismo Scanner para todas las iteraciones
            
            switch (userOption) {
                case "1":
                    unitMeController.createUnitMeasurement();
                    break;
                case "2":
                    unitMeController.findUnitMeasurementById();
                    break;
                case "3":
                    unitMeController.updateUnitMeasurement();
                    break;
                case "4":
                    unitMeController.deleteUnitMeasurement();
                    break;
                case "5":
                    unitMeController.listAllUnitMeasurements();
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
