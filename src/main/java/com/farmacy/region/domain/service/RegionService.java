package com.farmacy.region.domain.service;

import com.farmacy.region.domain.entity.Region;

import java.util.List;
import java.util.Optional;

public interface RegionService {
    void createRegion(Region region);
    Optional<Region> findRegionById(String codeReg);
    void updateRegion(String codeReg, String nameReg, String codeCountry);
    void deleteRegion(String codeReg);
    List<Region> listAllRegions();
}
