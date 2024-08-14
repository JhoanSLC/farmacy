package com.farmacy.modeAdministration.infrastructure.controller;

import java.util.Scanner;

import com.farmacy.modeAdministration.application.CreateModeAdUC;
import com.farmacy.modeAdministration.application.DeleteModeAdUC;
import com.farmacy.modeAdministration.application.FindModeByIdUC;
import com.farmacy.modeAdministration.application.ListAllModeAdUC;
import com.farmacy.modeAdministration.application.UpdateModeAdUC;
import com.farmacy.modeAdministration.domain.entitiy.ModeAdministration;
import com.farmacy.modeAdministration.domain.service.ModeAdService;
import com.farmacy.modeAdministration.infrastructure.repository.ModeAdRepository;
import com.farmacy.screen.ScreenController;
import java.util.List;

public class ModeAdController {
    private ModeAdService modeAdService;
    private CreateModeAdUC createModeAdUC;
    private DeleteModeAdUC deleteModeAdUC;
    private FindModeByIdUC findModeByIdUC;
    private UpdateModeAdUC updateModeAdUC;
    private ListAllModeAdUC listAllModeAdUC;
    private Scanner scan = new Scanner(System.in);
    private ScreenController screen = new ScreenController();

    public ModeAdController() {
        this.modeAdService = new ModeAdRepository();
        this.createModeAdUC = new CreateModeAdUC(modeAdService);
        this.deleteModeAdUC = new DeleteModeAdUC(modeAdService);
        this.findModeByIdUC = new FindModeByIdUC(modeAdService);
        this.updateModeAdUC = new UpdateModeAdUC(modeAdService);
        this.listAllModeAdUC = new ListAllModeAdUC(modeAdService);
    }

    public void createModeAd(){
        screen.clean();
        System.out.println("Type the description of the mode administration");
        String modeAdDescription = scan.nextLine();

        ModeAdministration modeAd = new ModeAdministration();
        modeAd.setDescriptionMode(modeAdDescription);

        createModeAdUC.create(modeAd);
    }

    public void deleteModeAd(){
        screen.clean();
        System.out.println("Type the id of the mode administration you want to delete");
        Long scannedId = scan.nextLong();
        scan.nextLine();
        deleteModeAdUC.delete(scannedId);
    }

    public void findModeAdById(){
        screen.clean();
        System.out.println("Type the id of the mode administration you want to see");
        long scannedId = scan.nextLong();
        scan.nextLine();
        findModeByIdUC.findById(scannedId);
        screen.pause();
    }

    public void updateModeAd(){
        screen.clean();
        System.out.println("Type the id of the mode administration you want to update");
        long inId = scan.nextLong();
        scan.nextLine();
        screen.clean();
        System.out.println("Type the new description for this mode Administration");
        String inDescription = scan.nextLine();
        updateModeAdUC.update(inId, inDescription);

    }

    public void listAllModeAd() {
        screen.clean();
        System.out.println("Listing all mode administrations:");
        List<ModeAdministration> modeAdministrations = listAllModeAdUC.listAll();

        if (modeAdministrations.isEmpty()) {
            System.out.println("No mode administrations found.");
        } else {
            for (ModeAdministration modeAdministration : modeAdministrations) {
                System.out.println("");
                System.out.printf("Id: %d%nDescription %s%n", modeAdministration.getId(), modeAdministration.getDescriptionMode());
            }
        }
        System.out.printf("%nPress any key to continue...");
        scan.nextLine();
    }
}
