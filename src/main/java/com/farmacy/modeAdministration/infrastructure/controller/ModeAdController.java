package com.farmacy.modeAdministration.infrastructure.controller;

import java.util.Scanner;

import com.farmacy.modeAdministration.application.CreateModeAdUC;
import com.farmacy.modeAdministration.application.DeleteModeAdUC;
import com.farmacy.modeAdministration.domain.entitiy.ModeAdministration;
import com.farmacy.modeAdministration.domain.service.ModeAdService;
import com.farmacy.modeAdministration.infrastructure.repository.ModeAdRepository;

public class ModeAdController {
    private ModeAdService modeAdService;
    private CreateModeAdUC createModeAdUC;
    private DeleteModeAdUC deleteModeAdUC;

    public ModeAdController() {
        this.modeAdService = new ModeAdRepository();
        this.createModeAdUC = new CreateModeAdUC(modeAdService);
        this.deleteModeAdUC = new DeleteModeAdUC(modeAdService);
    }

    public void createModeAd(){
        try (Scanner scan = new Scanner(System.in)){
            System.out.println("Type the description of the mode administration");
            String modeAdDescription = scan.nextLine();

            ModeAdministration modeAd = new ModeAdministration();
            modeAd.setDescriptionMode(modeAdDescription);

            createModeAdUC.create(modeAd);
        }
    }

    public void deleteModeAd(){
        try (Scanner scan = new Scanner(System.in)){
            System.out.println("Type the id of the mode administration you want to delete");
            Long scannedId = scan.nextLong();
            scan.nextLine();
            deleteModeAdUC.delete(scannedId);
        }

    }
}
