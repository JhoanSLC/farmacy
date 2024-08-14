package com.farmacy.region.application;

import com.farmacy.region.domain.entity.Region;
import com.farmacy.region.domain.service.RegionService;

public class CreateRegionUC {
    private final RegionService regionService;

    public CreateRegionUC(RegionService regionService) {
        this.regionService = regionService;
    }

    public void create(Region region) {
        regionService.createRegion(region);
    }
}
