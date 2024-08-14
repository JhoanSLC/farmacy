package com.farmacy.region.application;

import java.util.List;
import com.farmacy.region.domain.entity.Region;
import com.farmacy.region.domain.service.RegionService;

public class ListAllRegionsUC {
    private final RegionService regionService;

    public ListAllRegionsUC(RegionService regionService) {
        this.regionService = regionService;
    }

    public List<Region> listAll() {
        return regionService.listAllRegions();
    }
}
