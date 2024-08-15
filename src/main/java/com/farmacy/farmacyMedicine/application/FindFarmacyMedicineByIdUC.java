package com.farmacy.farmacyMedicine.application;

import com.farmacy.farmacyMedicine.domain.entity.FarmacyMedicine;
import com.farmacy.farmacyMedicine.domain.service.FarmacyMedicineService;

import java.util.Optional;

public class FindFarmacyMedicineByIdUC {
    private final FarmacyMedicineService farmacyMedicineService;

    public FindFarmacyMedicineByIdUC(FarmacyMedicineService farmacyMedicineService) {
        this.farmacyMedicineService = farmacyMedicineService;
    }

    public Optional<FarmacyMedicine> findById(int id) {
        return farmacyMedicineService.findFarmacyMedicineById(id);
    }
}
