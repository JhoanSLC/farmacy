package com.farmacy.labatory.infrastructure.controller;

import com.farmacy.labatory.application.*;
import com.farmacy.labatory.domain.entity.Labatory;
import com.farmacy.labatory.domain.service.LabatoryService;
import com.farmacy.labatory.infrastructure.repository.LabatoryRepository;
import com.farmacy.screen.ScreenController;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class LabatoryController {
    private final LabatoryService labatoryService;
    private final CreateLabatoryUC createLabatoryUC;
    private final DeleteLabatoryUC deleteLabatoryUC;
    private final FindLabatoryByIdUC findLabatoryByIdUC;
    private final UpdateLabatoryUC updateLabatoryUC;
    private final ListAllLabatoriesUC listAllLabatoriesUC;
    private final Scanner scan = new Scanner(System.in);
    private final ScreenController screen = new ScreenController();

    public LabatoryController() {
        this.labatoryService = new LabatoryRepository();
        this.createLabatoryUC = new CreateLabatoryUC(labatoryService);
        this.deleteLabatoryUC = new DeleteLabatoryUC(labatoryService);
        this.findLabatoryByIdUC = new FindLabatoryByIdUC(labatoryService);
        this.updateLabatoryUC = new UpdateLabatoryUC(labatoryService);
        this.listAllLabatoriesUC = new ListAllLabatoriesUC(labatoryService);
    }

    public void createLabatory() {
        screen.clean();
        System.out.println("Type the name of the lab");
        String nameLab = scan.nextLine();
        System.out.println("Type the city code");
        String codeCityReg = scan.nextLine();

        Labatory labatory = new Labatory();
        labatory.setNameLab(nameLab);
        labatory.setCodeCityReg(codeCityReg);

        createLabatoryUC.create(labatory);
        System.out.println("Labatory created succesfully!");
        screen.pause();
    }

    public void deleteLabatory() {
        screen.clean();
        System.out.println("Type the ID of the lab you want to delete");
        int id = Integer.parseInt(scan.nextLine());
        deleteLabatoryUC.delete(id);
        System.out.println("");
        System.out.println("Deleted succesfully!!");
        screen.pause();
    }

    public void findLabatoryById() {
        screen.clean();
        System.out.println("Type the ID of the lab you want to see");
        int id = Integer.parseInt(scan.nextLine());
        Optional<Labatory> labatory = findLabatoryByIdUC.findById(id);

        labatory.ifPresentOrElse(
            l -> System.out.printf("%nID: %d%nName: %s%nCity Code: %s%n", l.getId(), l.getNameLab(), l.getCodeCityReg()),
            () -> System.out.println("Lab not found.")
        );
        screen.pause();
    }

    public void updateLabatory() {
        screen.clean();
        System.out.println("Type the ID of the lab you want to update");
        int id = Integer.parseInt(scan.nextLine());
        System.out.println("Type the new name for this lab");
        String nameLab = scan.nextLine();
        updateLabatoryUC.update(id, nameLab);
    }

    public void listAllLabatories() {
        screen.clean();
        System.out.println("Listing all labs:");
        List<Labatory> labs = listAllLabatoriesUC.listAll();

        if (labs.isEmpty()) {
            System.out.println("No labs found.");
        } else {
            for (Labatory labatory : labs) {
                System.out.println("");
                System.out.printf("ID: %d%nName: %s%nCity Code: %s%n", labatory.getId(), labatory.getNameLab(), labatory.getCodeCityReg());
            }
        }
        System.out.printf("%nPress any key to continue...");
        scan.nextLine();
    }
}
