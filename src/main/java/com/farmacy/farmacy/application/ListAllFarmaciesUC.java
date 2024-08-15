package com.farmacy.farmacy.application;

import com.farmacy.farmacy.domain.entity.Farmacy;
import com.farmacy.farmacy.domain.service.FarmacyService;

import java.util.List;

public class ListAllFarmaciesUC {
    private final FarmacyService farmacyService;

    public ListAllFarmaciesUC(FarmacyService farmacyService) {
        this.farmacyService = farmacyService;
    }

    public List<Farmacy> listAll() {
        return farmacyService.listAllFarmacies();
    }
}
