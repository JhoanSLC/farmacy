package com.farmacy.ui;

import java.util.Scanner;
import com.farmacy.screen.ScreenController;

public class MainUi {
    private final ScreenController screen = new ScreenController();
    private final Scanner sc = new Scanner(System.in); 
    private final ModeAdMenu modeAdMenu = new ModeAdMenu();
    private final UnitMeasurementMenu unitMeasurementMenu = new UnitMeasurementMenu(); 
    private final ActivePrincipleMenu activePrincipleMenu = new ActivePrincipleMenu();
    private final CountryMenu countryMenu = new CountryMenu(); // Nuevo menú

    public MainUi() {}

    public void mainMenu() {
        boolean isThisRunning = true;
        while (isThisRunning) {
            screen.clean();
            System.out.printf("++++++++++++++++++%n++ FARMACY CRUD ++%n++++++++++++++++++%n");
            System.out.printf("%nType the number of the table you want to access:%n");
            System.out.printf("%n1. modeAdministration%n");
            System.out.println("2. unitMeasurement");
            System.out.println("3. activePrinciple");
            System.out.println("4. country"); // Nuevo menú
            System.out.printf("0. Exit%n");
            String userOption = sc.nextLine();
            switch (userOption) {
                case "1":
                    modeAdMenu.modeAdministrationMenu();
                    break;
                case "2":
                    unitMeasurementMenu.unitMeasurementMenu();
                    break;
                case "3":
                    activePrincipleMenu.showMenu();
                    break;
                case "4":
                    countryMenu.countryMenu(); // Accede al menú de country
                    break;
                case "0":
                    isThisRunning = false;
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
