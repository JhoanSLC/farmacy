package com.farmacy.region.infrastructure.controller;

import com.farmacy.screen.ScreenController;
import com.farmacy.region.application.CreateRegionUC;
import com.farmacy.region.application.DeleteRegionUC;
import com.farmacy.region.application.FindRegionByIdUC;
import com.farmacy.region.application.ListAllRegionsUC;
import com.farmacy.region.application.UpdateRegionUC;
import com.farmacy.region.domain.entity.Region;
import com.farmacy.region.domain.service.RegionService;
import com.farmacy.region.infrastructure.repository.RegionRepository;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class RegionController {
    private final RegionService regionService;
    private final CreateRegionUC createRegionUC;
    private final DeleteRegionUC deleteRegionUC;
    private final FindRegionByIdUC findRegionByIdUC;
    private final UpdateRegionUC updateRegionUC;
    private final ListAllRegionsUC listAllRegionsUC;
    private final Scanner scan = new Scanner(System.in);
    private final ScreenController screen = new ScreenController();

    public RegionController() {
        this.regionService = new RegionRepository();
        this.createRegionUC = new CreateRegionUC(regionService);
        this.deleteRegionUC = new DeleteRegionUC(regionService);
        this.findRegionByIdUC = new FindRegionByIdUC(regionService);
        this.updateRegionUC = new UpdateRegionUC(regionService);
        this.listAllRegionsUC = new ListAllRegionsUC(regionService);
    }

    public void createRegion() {
        screen.clean();
        System.out.println("Type the code of the region:");
        String codeReg = scan.nextLine();
        System.out.println("Type the name of the region:");
        String nameReg = scan.nextLine();
        System.out.println("Type the code of the country:");
        String codeCountry = scan.nextLine();

        Region region = new Region(codeReg, nameReg, codeCountry);
        createRegionUC.create(region);
        System.out.println("Region created successfully.");
        screen.pause();
    }

    public void deleteRegion() {
        screen.clean();
        System.out.println("Type the code of the region you want to delete:");
        String codeReg = scan.nextLine();
        deleteRegionUC.delete(codeReg);
        System.out.println("Region deleted successfully.");
        screen.pause();
    }

    public void findRegionById() {
        screen.clean();
        System.out.println("Type the code of the region you want to see:");
        String codeReg = scan.nextLine();
        Optional<Region> region = findRegionByIdUC.findById(codeReg);
        if (region.isPresent()) {
            System.out.println(region.get());
        } else {
            System.out.println("Region not found.");
        }
        screen.pause();
    }

    public void updateRegion() {
        screen.clean();
        System.out.println("Type the code of the region you want to update:");
        String codeReg = scan.nextLine();
        System.out.println("Type the new name for this region:");
        String nameReg = scan.nextLine();
        System.out.println("Type the new code of the country:");
        String codeCountry = scan.nextLine();

        updateRegionUC.update(codeReg, nameReg, codeCountry);
        System.out.println("Region updated successfully.");
        screen.pause();
    }

    public void listAllRegions() {
        screen.clean();
        System.out.println("Listing all regions:");
        List<Region> regions = listAllRegionsUC.listAll();

        if (regions.isEmpty()) {
            System.out.println("No regions found.");
        } else {
            for (Region region : regions) {
                System.out.println(region);
            }
        }
        screen.pause();
    }
}
