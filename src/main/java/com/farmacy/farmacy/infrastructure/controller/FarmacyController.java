package com.farmacy.farmacy.infrastructure.controller;

import com.farmacy.farmacy.application.*;
import com.farmacy.farmacy.domain.entity.Farmacy;
import com.farmacy.farmacy.domain.service.FarmacyService;
import com.farmacy.farmacy.infrastructure.repository.FarmacyRepository;
import com.farmacy.screen.ScreenController;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class FarmacyController {
    private final FarmacyService farmacyService;
    private final CreateFarmacyUC createFarmacyUC;
    private final DeleteFarmacyUC deleteFarmacyUC;
    private final FindFarmacyByIdUC findFarmacyByIdUC;
    private final UpdateFarmacyUC updateFarmacyUC;
    private final ListAllFarmaciesUC listAllFarmaciesUC;
    private final Scanner scan = new Scanner(System.in);
    private final ScreenController screen = new ScreenController();

    public FarmacyController() {
        this.farmacyService = new FarmacyRepository();
        this.createFarmacyUC = new CreateFarmacyUC(farmacyService);
        this.deleteFarmacyUC = new DeleteFarmacyUC(farmacyService);
        this.findFarmacyByIdUC = new FindFarmacyByIdUC(farmacyService);
        this.updateFarmacyUC = new UpdateFarmacyUC(farmacyService);
        this.listAllFarmaciesUC = new ListAllFarmaciesUC(farmacyService);
    }

    public void createFarmacy() {
        screen.clean();
        System.out.println("Enter the name of the pharmacy:");
        String nameFarmacy = scan.nextLine();
        System.out.println("Enter the address of the pharmacy:");
        String addressFarmacy = scan.nextLine();
        System.out.println("Enter the longitude:");
        double lonFarmacy = Double.parseDouble(scan.nextLine());
        System.out.println("Enter the latitude:");
        double latFarmacy = Double.parseDouble(scan.nextLine());
        System.out.println("Enter the city code:");
        String codeCityFarm = scan.nextLine();
        System.out.println("Enter the logo (filename):");
        String logoFarmacy = scan.nextLine();

        Farmacy farmacy = new Farmacy();
        farmacy.setNameFarmacy(nameFarmacy);
        farmacy.setAddressFarmacy(addressFarmacy);
        farmacy.setLonFarmacy(lonFarmacy);
        farmacy.setLatFarmacy(latFarmacy);
        farmacy.setCodeCityFarm(codeCityFarm);
        farmacy.setLogoFarmacy(logoFarmacy);

        createFarmacyUC.create(farmacy);
        screen.clean();
        System.out.println("Created succesfully!");
        screen.pause();
    }

    public void deleteFarmacy() {
        screen.clean();
        System.out.println("Enter the ID of the pharmacy you want to delete:");
        int idFarmacy = Integer.parseInt(scan.nextLine());
        deleteFarmacyUC.delete(idFarmacy);
    }

    public void findFarmacyById() {
        screen.clean();
        System.out.println("Enter the ID of the pharmacy you want to view:");
        int idFarmacy = Integer.parseInt(scan.nextLine());
        Optional<Farmacy> farmacy = findFarmacyByIdUC.findById(idFarmacy);

        farmacy.ifPresentOrElse(
            f -> System.out.printf("%nID: %d%nName: %s%nAddress: %s%nLongitude: %.2f%nLatitude: %.2f%nCity Code: %s%nLogo: %s%n",
                f.getIdFarmacy(), f.getNameFarmacy(), f.getAddressFarmacy(), f.getLonFarmacy(), f.getLatFarmacy(), f.getCodeCityFarm(), f.getLogoFarmacy()),
            () -> System.out.println("Pharmacy not found.")
        );
        screen.pause();
    }

    public void updateFarmacy() {
        screen.clean();
        System.out.println("Enter the ID of the pharmacy you want to update:");
        int idFarmacy = Integer.parseInt(scan.nextLine());
        System.out.println("Enter the new name of the pharmacy:");
        String nameFarmacy = scan.nextLine();
        System.out.println("Enter the new address:");
        String addressFarmacy = scan.nextLine();
        System.out.println("Enter the new longitude:");
        double lonFarmacy = Double.parseDouble(scan.nextLine());
        System.out.println("Enter the new latitude:");
        double latFarmacy = Double.parseDouble(scan.nextLine());
        System.out.println("Enter the new logo (filename):");
        String logoFarmacy = scan.nextLine();

        updateFarmacyUC.update(idFarmacy, nameFarmacy, addressFarmacy, lonFarmacy, latFarmacy, logoFarmacy);
    }

    public void listAllFarmacies() {
        screen.clean();
        System.out.println("Listing all pharmacies:");
        List<Farmacy> farmacies = listAllFarmaciesUC.listAll();

        if (farmacies.isEmpty()) {
            System.out.println("No pharmacies found.");
        } else {
            for (Farmacy farmacy : farmacies) {
                System.out.println("");
                System.out.printf("ID: %d%nName: %s%nAddress: %s%nLongitude: %.2f%nLatitude: %.2f%nCity Code: %s%nLogo: %s%n",
                    farmacy.getIdFarmacy(), farmacy.getNameFarmacy(), farmacy.getAddressFarmacy(), farmacy.getLonFarmacy(), farmacy.getLatFarmacy(), farmacy.getCodeCityFarm(), farmacy.getLogoFarmacy());
            }
        }
        System.out.printf("%nPress any key to continue...");
        scan.nextLine();
    }
}
