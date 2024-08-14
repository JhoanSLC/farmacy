package com.farmacy.medicine.application;

import com.farmacy.medicine.domain.entity.Medicine;
import com.farmacy.medicine.domain.service.MedicineService;

import java.util.Optional;

public class FindMedicineByIdUC {
    private final MedicineService medicineService;

    public FindMedicineByIdUC(MedicineService medicineService) {
        this.medicineService = medicineService;
    }

    public Optional<Medicine> findById(int id) {
        return medicineService.findMedicineById(id);
    }
}
