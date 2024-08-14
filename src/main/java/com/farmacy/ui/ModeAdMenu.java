package com.farmacy.ui;

import com.farmacy.modeAdministration.infrastructure.controller.ModeAdController;
import java.util.Scanner;
import com.farmacy.screen.ScreenController;

public class ModeAdMenu {
    private final ModeAdController modeAdController;
    private final ScreenController screen = new ScreenController();
    private final Scanner sc = new Scanner(System.in); // Mueve el Scanner fuera del bucle

    public ModeAdMenu() {
        this.modeAdController = new ModeAdController();
    }

    public void modeAdministrationMenu() {
        boolean isRunning = true;
        while (isRunning) {
            screen.clean();
            System.out.printf("++++++++++++++++++++++++++%n++ Mode Administration CRUD ++%n++++++++++++++++++++++++++%n");
            System.out.printf("%nType the number of the action you want to perform%n");
            System.out.printf("%n1. Create modeAdministration%n2. Find modeAdministration by ID%n3. Update modeAdministration%n4. Delete modeAdministration%n5. List all modeAdministrations%n6. Return to Main Menu%n");
            String userOption = sc.nextLine(); // Usa el mismo Scanner para todas las iteraciones
            
            switch (userOption) {
                case "1":
                    modeAdController.createModeAd();
                    break;
                case "2":
                    modeAdController.findModeAdById();
                    break;
                case "3":
                    modeAdController.updateModeAd();
                    break;
                case "4":
                    modeAdController.deleteModeAd();
                    break;
                case "5":
                    modeAdController.listAllModeAd();
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
