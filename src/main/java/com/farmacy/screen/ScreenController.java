package com.farmacy.screen;

import java.util.Scanner;

public class ScreenController {
    protected String os = System.getProperty("os.name");

    public ScreenController(){}

    public void clean() {

        try {
            if (os.contains("Windows")) {
                // Limpia la consola en Windows
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                // Limpia la consola en Unix/Linux/Mac
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void pause(){
        Scanner scan = new Scanner(System.in);
        System.out.printf("%nPress ENTER to continue...%n");
        scan.nextLine();
    }
}
