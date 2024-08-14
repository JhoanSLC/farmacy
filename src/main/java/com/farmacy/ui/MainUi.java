package com.farmacy.ui;

import java.util.Scanner;
import com.farmacy.screen.ScreenController;

public class MainUi {
    private final ScreenController screen = new ScreenController();
    private final Scanner sc = new Scanner(System.in); // Mueve el Scanner fuera del bucle
    private final ModeAdMenu modeAdMenu = new ModeAdMenu();

    public MainUi(){}

    public void mainMenu() {
        boolean isThisRunning = true;
        while (isThisRunning){
            screen.clean();
            System.out.printf("++++++++++++++++++%n++ FARMACY CRUD ++%n++++++++++++++++++%n");
            System.out.printf("%nType the number of the table you want to access:%n");
            System.out.println("%n1. modeAdministration");
            System.out.println("2. ???");
            System.out.println("3. ???");
            System.out.println("0. Exit");
            String userOption = sc.nextLine(); // Lee la entrada del usuario
            switch (userOption) {
                case "1":
                    modeAdMenu.modeAdministrationMenu(); // Navega al menú de modeAdministration
                    break;
                case "0":
                    isThisRunning = false; // Finaliza el bucle, saliendo del programa
                    break;
                default:
                    screen.clean();
                    System.out.println("Please select a valid option");
                    break;
            }
        }
        System.out.println("Exiting the program. Goodbye!");
    }
}
