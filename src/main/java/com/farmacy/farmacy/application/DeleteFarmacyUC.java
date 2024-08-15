package com.farmacy.farmacy.application;

import com.farmacy.farmacy.domain.service.FarmacyService;

public class DeleteFarmacyUC {
    private final FarmacyService farmacyService;

    public DeleteFarmacyUC(FarmacyService farmacyService) {
        this.farmacyService = farmacyService;
    }

    public void delete(int idFarmacy) {
        farmacyService.deleteFarmacy(idFarmacy);
    }
}
