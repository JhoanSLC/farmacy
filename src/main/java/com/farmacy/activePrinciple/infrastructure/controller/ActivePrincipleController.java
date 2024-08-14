package com.farmacy.activePrinciple.infrastructure.controller;

import java.util.List;
import java.util.Scanner;

import com.farmacy.activePrinciple.application.CreateActivePrincipleUC;
import com.farmacy.activePrinciple.application.DeleteActivePrincipleUC;
import com.farmacy.activePrinciple.application.FindActivePrincipleByIdUC;
import com.farmacy.activePrinciple.application.ListAllActivePrinciplesUC;
import com.farmacy.activePrinciple.application.UpdateActivePrincipleUC;
import com.farmacy.activePrinciple.domain.entity.ActivePrinciple;
import com.farmacy.activePrinciple.domain.service.ActivePrincipleService;
import com.farmacy.activePrinciple.infrastructure.repository.ActivePrincipleRepository;
import com.farmacy.screen.ScreenController;

public class ActivePrincipleController {
    private ActivePrincipleService activePrincipleService;
    private CreateActivePrincipleUC createActivePrincipleUC;
    private DeleteActivePrincipleUC deleteActivePrincipleUC;
    private FindActivePrincipleByIdUC findActivePrincipleByIdUC;
    private UpdateActivePrincipleUC updateActivePrincipleUC;
    private ListAllActivePrinciplesUC listAllActivePrinciplesUC;
    private Scanner scan = new Scanner(System.in);
    private ScreenController screen = new ScreenController();

    public ActivePrincipleController() {
        this.activePrincipleService = new ActivePrincipleRepository();
        this.createActivePrincipleUC = new CreateActivePrincipleUC(activePrincipleService);
        this.deleteActivePrincipleUC = new DeleteActivePrincipleUC(activePrincipleService);
        this.findActivePrincipleByIdUC = new FindActivePrincipleByIdUC(activePrincipleService);
        this.updateActivePrincipleUC = new UpdateActivePrincipleUC(activePrincipleService);
        this.listAllActivePrinciplesUC = new ListAllActivePrinciplesUC(activePrincipleService);
    }

    public void createActivePrinciple() {
        screen.clean();
        System.out.println("Type the name of the active principle:");
        String nameAp = scan.nextLine();

        ActivePrinciple activePrinciple = new ActivePrinciple();
        activePrinciple.setNameAp(nameAp);

        createActivePrincipleUC.create(activePrinciple);
    }

    public void deleteActivePrinciple() {
        screen.clean();
        System.out.println("Type the ID of the active principle you want to delete:");
        long idAp = scan.nextLong();
        scan.nextLine(); // Limpiar el buffer
        deleteActivePrincipleUC.delete(idAp);
    }

    public void findActivePrincipleById() {
        screen.clean();
        System.out.println("Type the ID of the active principle you want to view:");
        long idAp = scan.nextLong();
        scan.nextLine(); // Limpiar el buffer
        findActivePrincipleByIdUC.findById(idAp);
    }

    public void updateActivePrinciple() {
        screen.clean();
        System.out.println("Type the ID of the active principle you want to update:");
        long idAp = scan.nextLong();
        scan.nextLine(); // Limpiar el buffer
        System.out.println("Type the new name for this active principle:");
        String nameAp = scan.nextLine();

        updateActivePrincipleUC.update(idAp, nameAp);
        System.out.println("Active principle updated successfully.");
    }

    public void listAllActivePrinciples() {
        screen.clean();
        System.out.println("Listing all active principles:");
        List<ActivePrinciple> activePrinciples = listAllActivePrinciplesUC.listAll();

        if (activePrinciples.isEmpty()) {
            System.out.println("No active principles found.");
        } else {
            for (ActivePrinciple activePrinciple : activePrinciples) {
                System.out.printf("Id: %d%nName: %s%n", activePrinciple.getIdAp(), activePrinciple.getNameAp());
            }
        }
    }
}
