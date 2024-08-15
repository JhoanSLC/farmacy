package com.farmacy.farmacyMedicine.application;

import com.farmacy.farmacyMedicine.domain.entity.FarmacyMedicine;
import com.farmacy.farmacyMedicine.domain.service.FarmacyMedicineService;

public class CreateFarmacyMedicineUC {
    private final FarmacyMedicineService farmacyMedicineService;

    public CreateFarmacyMedicineUC(FarmacyMedicineService farmacyMedicineService) {
        this.farmacyMedicineService = farmacyMedicineService;
    }

    public void create(FarmacyMedicine farmacyMedicine) {
        farmacyMedicineService.createFarmacyMedicine(farmacyMedicine);
    }
}
