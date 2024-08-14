package com.farmacy.region.application;

import com.farmacy.region.domain.service.RegionService;

public class DeleteRegionUC {
    private final RegionService regionService;

    public DeleteRegionUC(RegionService regionService) {
        this.regionService = regionService;
    }

    public void delete(String codeReg) {
        regionService.deleteRegion(codeReg);
    }
}
