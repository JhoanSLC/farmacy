package com.farmacy.farmacyMedicine.application;

import com.farmacy.farmacyMedicine.domain.entity.FarmacyMedicine;
import com.farmacy.farmacyMedicine.domain.service.FarmacyMedicineService;

import java.util.List;

public class ListAllFarmacyMedicinesUC {
    private final FarmacyMedicineService farmacyMedicineService;

    public ListAllFarmacyMedicinesUC(FarmacyMedicineService farmacyMedicineService) {
        this.farmacyMedicineService = farmacyMedicineService;
    }

    public List<FarmacyMedicine> listAll() {
        return farmacyMedicineService.listAllFarmacyMedicines();
    }
}
