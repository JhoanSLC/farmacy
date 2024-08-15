package com.farmacy.farmacyMedicine.application;

import com.farmacy.farmacyMedicine.domain.service.FarmacyMedicineService;

public class DeleteFarmacyMedicineUC {
    private final FarmacyMedicineService farmacyMedicineService;

    public DeleteFarmacyMedicineUC(FarmacyMedicineService farmacyMedicineService) {
        this.farmacyMedicineService = farmacyMedicineService;
    }

    public void delete(int id) {
        farmacyMedicineService.deleteFarmacyMedicine(id);
    }
}
