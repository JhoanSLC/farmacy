package com.farmacy.ui;

import java.util.Scanner;

import com.farmacy.activePrinciple.infrastructure.controller.ActivePrincipleController;
import com.farmacy.screen.ScreenController;

public class ActivePrincipleMenu {
    private ActivePrincipleController activePrincipleController;
    private Scanner scan = new Scanner(System.in);
    private ScreenController screen = new ScreenController();

    public ActivePrincipleMenu() {
        this.activePrincipleController = new ActivePrincipleController();
    }

    public void showMenu() {
        boolean running = true;

        while (running) {
            screen.celan()
            System.out.println("--- Active Principle Menu ---\n");
            System.out.println("1. Create Active Principle");
            System.out.println("2. Delete Active Principle");
            System.out.println("3. Find Active Principle by ID");
            System.out.println("4. Update Active Principle");
            System.out.println("5. List All Active Principles");
            System.out.println("6. Exit\n");

            System.out.print("Choose an option: ");
            int choice = scan.nextInt();
            scan.nextLine(); // Clear buffer

            switch (choice) {
                case 1:
                    activePrincipleController.createActivePrinciple();
                    break;
                case 2:
                    activePrincipleController.deleteActivePrinciple();
                    break;
                case 3:
                    activePrincipleController.findActivePrincipleById();
                    break;
                case 4:
                    activePrincipleController.updateActivePrinciple();
                    break;
                case 5:
                    activePrincipleController.listAllActivePrinciples();
                    break;
                case 6:
                    System.out.println("Exiting...");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public static void main(String[] args) {
        ActivePrincipleMenu menu = new ActivePrincipleMenu();
        menu.showMenu();
    }
}
