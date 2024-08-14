package com.farmacy.ui;

import com.farmacy.labatory.infrastructure.controller.LabatoryController;
import com.farmacy.screen.ScreenController;

import java.util.Scanner;

public class LabatoryMenu {
    private final LabatoryController labatoryController;
    private final Scanner sc = new Scanner(System.in);
    private final ScreenController screen = new ScreenController();

    public LabatoryMenu() {
        this.labatoryController = new LabatoryController();
    }

    public void labatoryMenu() {
        boolean isRunning = true;
        while (isRunning) {
            screen.clean();
            System.out.printf("+++++++++++++++++++%n++ Labatory CRUD ++%n+++++++++++++++++++%n");
            System.out.printf("%nType the number of the action you want to perform%n");
            System.out.printf("%n1. Create labatory%n2. Find labatory by ID%n3. Update labatory%n4. Delete labatory%n5. List all labatories%n6. Return to Main Menu%n");
            System.out.println("");
            System.out.print("Choose an option: ");
            String userOption = sc.nextLine();
            
            switch (userOption) {
                case "1":
                    labatoryController.createLabatory();
                    break;
                case "2":
                    labatoryController.findLabatoryById();
                    break;
                case "3":
                    labatoryController.updateLabatory();
                    break;
                case "4":
                    labatoryController.deleteLabatory();
                    break;
                case "5":
                    labatoryController.listAllLabatories();
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
