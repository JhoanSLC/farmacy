package com.farmacy.farmacy.application;

import com.farmacy.farmacy.domain.entity.Farmacy;
import com.farmacy.farmacy.domain.service.FarmacyService;

import java.util.Optional;

public class FindFarmacyByIdUC {
    private final FarmacyService farmacyService;

    public FindFarmacyByIdUC(FarmacyService farmacyService) {
        this.farmacyService = farmacyService;
    }

    public Optional<Farmacy> findById(int idFarmacy) {
        return farmacyService.findFarmacyById(idFarmacy);
    }
}
