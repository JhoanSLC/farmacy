package com.farmacy.region.application;

import java.util.Optional;
import com.farmacy.region.domain.entity.Region;
import com.farmacy.region.domain.service.RegionService;

public class FindRegionByIdUC {
    private final RegionService regionService;

    public FindRegionByIdUC(RegionService regionService) {
        this.regionService = regionService;
    }

    public Optional<Region> findById(String codeReg) {
        return regionService.findRegionById(codeReg);
    }
}
