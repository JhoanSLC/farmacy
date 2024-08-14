package com.farmacy.modeAdministration.infrastructure.controller;

import java.util.Scanner;

import com.farmacy.modeAdministration.application.CreateModeAdUC;
import com.farmacy.modeAdministration.application.DeleteModeAdUC;
import com.farmacy.modeAdministration.application.FindModeByIdUC;
import com.farmacy.modeAdministration.application.UpdateModeAdUC;
import com.farmacy.modeAdministration.domain.entitiy.ModeAdministration;
import com.farmacy.modeAdministration.domain.service.ModeAdService;
import com.farmacy.modeAdministration.infrastructure.repository.ModeAdRepository;
import com.farmacy.screen.ScreenController;

public class ModeAdController {
    private ModeAdService modeAdService;
    private CreateModeAdUC createModeAdUC;
    private DeleteModeAdUC deleteModeAdUC;
    private FindModeByIdUC findModeByIdUC;
    private UpdateModeAdUC updateModeAdUC;
    private Scanner scan = new Scanner(System.in);
    private ScreenController screen = new ScreenController();

    public ModeAdController() {
        this.modeAdService = new ModeAdRepository();
        this.createModeAdUC = new CreateModeAdUC(modeAdService);
        this.deleteModeAdUC = new DeleteModeAdUC(modeAdService);
        this.findModeByIdUC = new FindModeByIdUC(modeAdService);
        this.updateModeAdUC = new UpdateModeAdUC(modeAdService);
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
}
