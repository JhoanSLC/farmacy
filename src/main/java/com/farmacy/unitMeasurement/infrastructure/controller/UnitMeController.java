package com.farmacy.unitMeasurement.infrastructure.controller;

import java.util.Scanner;

import com.farmacy.screen.ScreenController;
import com.farmacy.unitMeasurement.application.CreateUnitMeasurementUC;
import com.farmacy.unitMeasurement.application.DeleteUnitMeasurementUC;
import com.farmacy.unitMeasurement.application.FindUnitMeasurementByIdUC;
import com.farmacy.unitMeasurement.application.UpdateUnitMeasurementUC;
import com.farmacy.unitMeasurement.domain.entity.UnitMeasurement;
import com.farmacy.unitMeasurement.domain.service.UnitMeasurementService;
import com.farmacy.unitMeasurement.infrastructure.repository.UnitMeRepository;

public class UnitMeController {
    private final UnitMeasurementService unitMeasurementService;
    private final CreateUnitMeasurementUC createUnitMeasurementUC;
    private final DeleteUnitMeasurementUC deleteUnitMeasurementUC;
    private final FindUnitMeasurementByIdUC findUnitMeasurementByIdUC;
    private final UpdateUnitMeasurementUC updateUnitMeasurementUC;
    private final Scanner scan = new Scanner(System.in);
    private final ScreenController screen = new ScreenController();

    public UnitMeController() {
        this.unitMeasurementService = new UnitMeRepository();
        this.createUnitMeasurementUC = new CreateUnitMeasurementUC(unitMeasurementService);
        this.deleteUnitMeasurementUC = new DeleteUnitMeasurementUC(unitMeasurementService);
        this.findUnitMeasurementByIdUC = new FindUnitMeasurementByIdUC(unitMeasurementService);
        this.updateUnitMeasurementUC = new UpdateUnitMeasurementUC(unitMeasurementService);
    }

    public void createUnitMeasurement() {
        screen.clean();
        System.out.println("Type the name of the unit of measurement:");
        String nameUm = scan.nextLine();

        UnitMeasurement unitMeasurement = new UnitMeasurement();
        unitMeasurement.setNameUm(nameUm);

        createUnitMeasurementUC.create(unitMeasurement);
    }

    public void deleteUnitMeasurement() {
        screen.clean();
        System.out.println("Type the id of the unit of measurement you want to delete:");
        long scannedId = scan.nextLong();
        scan.nextLine();
        deleteUnitMeasurementUC.delete(scannedId);
    }

    public void findUnitMeasurementById() {
        screen.clean();
        System.out.println("Type the id of the unit of measurement you want to see:");
        long scannedId = scan.nextLong();
        scan.nextLine();
        findUnitMeasurementByIdUC.findById(scannedId);
    }

    public void updateUnitMeasurement() {
        screen.clean();
        System.out.println("Type the id of the unit of measurement you want to update:");
        long inId = scan.nextLong();
        scan.nextLine();
        screen.clean();
        System.out.println("Type the new name for this unit of measurement:");
        String inNameUm = scan.nextLine();
        updateUnitMeasurementUC.update(inId, inNameUm);
    }
}
