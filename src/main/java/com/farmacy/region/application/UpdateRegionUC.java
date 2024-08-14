package com.farmacy.region.application;

import com.farmacy.region.domain.service.RegionService;

public class UpdateRegionUC {
    private final RegionService regionService;

    public UpdateRegionUC(RegionService regionService) {
        this.regionService = regionService;
    }

    public void update(String codeReg, String nameReg, String codeCountry) {
        regionService.updateRegion(codeReg, nameReg, codeCountry);
    }
}
