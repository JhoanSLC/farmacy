package com.farmacy.farmacyMedicine.application;

import com.farmacy.farmacyMedicine.domain.service.FarmacyMedicineService;

public class UpdateFarmacyMedicineUC {
    private final FarmacyMedicineService farmacyMedicineService;

    public UpdateFarmacyMedicineUC(FarmacyMedicineService farmacyMedicineService) {
        this.farmacyMedicineService = farmacyMedicineService;
    }

    public void update(int id, double price) {
        farmacyMedicineService.updateFarmacyMedicine(id, price);
    }
}
