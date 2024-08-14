package com.farmacy.medicine.application;

import com.farmacy.medicine.domain.entity.Medicine;
import com.farmacy.medicine.domain.service.MedicineService;

public class CreateMedicineUC {
    private final MedicineService medicineService;

    public CreateMedicineUC(MedicineService medicineService) {
        this.medicineService = medicineService;
    }

    public void create(Medicine medicine) {
        medicineService.createMedicine(medicine);
    }
}
