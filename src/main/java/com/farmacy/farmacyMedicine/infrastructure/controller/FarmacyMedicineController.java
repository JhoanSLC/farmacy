package com.farmacy.farmacyMedicine.infrastructure.controller;

import com.farmacy.farmacyMedicine.application.*;
import com.farmacy.farmacyMedicine.domain.entity.FarmacyMedicine;
import com.farmacy.farmacyMedicine.domain.service.FarmacyMedicineService;
import com.farmacy.farmacyMedicine.infrastructure.repository.FarmacyMedicineRepository;
import com.farmacy.screen.ScreenController;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class FarmacyMedicineController {
    private final FarmacyMedicineService farmacyMedicineService;
    private final CreateFarmacyMedicineUC createFarmacyMedicineUC;
    private final DeleteFarmacyMedicineUC deleteFarmacyMedicineUC;
    private final FindFarmacyMedicineByIdUC findFarmacyMedicineByIdUC;
    private final UpdateFarmacyMedicineUC updateFarmacyMedicineUC;
    private final ListAllFarmacyMedicinesUC listAllFarmacyMedicinesUC;
    private final Scanner scan = new Scanner(System.in);
    private final ScreenController screen = new ScreenController();

    public FarmacyMedicineController() {
        this.farmacyMedicineService = new FarmacyMedicineRepository();
        this.createFarmacyMedicineUC = new CreateFarmacyMedicineUC(farmacyMedicineService);
        this.deleteFarmacyMedicineUC = new DeleteFarmacyMedicineUC(farmacyMedicineService);
        this.findFarmacyMedicineByIdUC = new FindFarmacyMedicineByIdUC(farmacyMedicineService);
        this.updateFarmacyMedicineUC = new UpdateFarmacyMedicineUC(farmacyMedicineService);
        this.listAllFarmacyMedicinesUC = new ListAllFarmacyMedicinesUC(farmacyMedicineService);
    }

    public void createFarmacyMedicine() {
        screen.clean();
        System.out.println("Type the ID of the farmacy");
        int idFarmacy = Integer.parseInt(scan.nextLine());
        System.out.println("Type the ID of the medicine");
        int idMedicineFatrm = Integer.parseInt(scan.nextLine());
        System.out.println("Type the price of the medicine");
        double price = Double.parseDouble(scan.nextLine());

        FarmacyMedicine farmacyMedicine = new FarmacyMedicine();
        farmacyMedicine.setIdFarmacy(idFarmacy);
        farmacyMedicine.setIdMedicineFatrm(idMedicineFatrm);
        farmacyMedicine.setPrice(price);

        createFarmacyMedicineUC.create(farmacyMedicine);
    }

    public void deleteFarmacyMedicine() {
        screen.clean();
        System.out.println("Type the ID of the farmacy medicine entry you want to delete");
        int id = Integer.parseInt(scan.nextLine());
        deleteFarmacyMedicineUC.delete(id);
    }

    public void findFarmacyMedicineById() {
        screen.clean();
        System.out.println("Type the ID of the farmacy medicine entry you want to see");
        int id = Integer.parseInt(scan.nextLine());
        Optional<FarmacyMedicine> farmacyMedicine = findFarmacyMedicineByIdUC.findById(id);

        farmacyMedicine.ifPresentOrElse(
            fm -> System.out.printf(
                "ID: %d%nFarmacy ID: %d%nMedicine ID: %d%nPrice: %.2f%n",
                fm.getIdFarmacyMedicine(),
                fm.getIdFarmacy(),
                fm.getIdMedicineFatrm(),
                fm.getPrice()
            ),
            () -> System.out.println("Farmacy medicine entry not found.")
        );
        screen.pause();
    }

    public void updateFarmacyMedicine() {
        screen.clean();
        System.out.println("Type the ID of the farmacy medicine entry you want to update");
        int id = Integer.parseInt(scan.nextLine());
        System.out.println("Type the new price");
        double price = Double.parseDouble(scan.nextLine());
        updateFarmacyMedicineUC.update(id, price);
    }

    public void listAllFarmacyMedicines() {
        screen.clean();
        System.out.println("Listing all farmacy medicines:");
        List<FarmacyMedicine> farmacyMedicines = listAllFarmacyMedicinesUC.listAll();

        if (farmacyMedicines.isEmpty()) {
            System.out.println("No farmacy medicines found.");
        } else {
            for (FarmacyMedicine farmacyMedicine : farmacyMedicines) {
                System.out.println("");
                System.out.printf(
                    "ID: %d%nFarmacy ID: %d%nMedicine ID: %d%nPrice: %.2f%n",
                    farmacyMedicine.getIdFarmacyMedicine(),
                    farmacyMedicine.getIdFarmacy(),
                    farmacyMedicine.getIdMedicineFatrm(),
                    farmacyMedicine.getPrice()
                );
            }
        }
        System.out.printf("%nPress any key to continue...");
        scan.nextLine();
    }
}
