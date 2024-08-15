package com.farmacy.farmacy.application;

import com.farmacy.farmacy.domain.service.FarmacyService;

public class UpdateFarmacyUC {
    private final FarmacyService farmacyService;

    public UpdateFarmacyUC(FarmacyService farmacyService) {
        this.farmacyService = farmacyService;
    }

    public void update(int idFarmacy, String nameFarmacy, String addressFarmacy, double lonFarmacy, double latFarmacy, String logoFarmacy) {
        farmacyService.updateFarmacy(idFarmacy, nameFarmacy, addressFarmacy, lonFarmacy, latFarmacy, logoFarmacy);
    }
}
