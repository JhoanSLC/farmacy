package com.farmacy.farmacy.application;

import com.farmacy.farmacy.domain.entity.Farmacy;
import com.farmacy.farmacy.domain.service.FarmacyService;

public class CreateFarmacyUC {
    private final FarmacyService farmacyService;

    public CreateFarmacyUC(FarmacyService farmacyService) {
        this.farmacyService = farmacyService;
    }

    public void create(Farmacy farmacy) {
        farmacyService.createFarmacy(farmacy);
    }
}
