package com.farmacy.ui;

import java.util.Scanner;

import com.farmacy.screen.ScreenController;

public class MainUi {
    protected ScreenController screen = new ScreenController();
    public MainUi(){}

    public void mainMenu(){
        boolean isThisRunning = true;
        while (isThisRunning){
            try (Scanner sc = new Scanner(System.in)){
                screen.clean();
                System.out.printf("++++++++++++++++++%n++ FARMACY CRUD ++%n++++++++++++++++++%n");
                System.out.printf("%nType the number of the table you want to acces");
                System.out.println();
                System.out.printf("1. modeAdministration%n2. ???%n3. ???%n");
                String userOption = sc.nextLine();
                switch (userOption) {
                    case "1":
                        
                        break;
                
                    default:
                        screen.clean();
                        System.out.println("Please select a valid option");
                        break;
                }
    
            }
        }
    }
}
