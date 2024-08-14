package com.farmacy.medicine.application;

import com.farmacy.medicine.domain.service.MedicineService;

public class DeleteMedicineUC {
    private final MedicineService medicineService;

    public DeleteMedicineUC(MedicineService medicineService) {
        this.medicineService = medicineService;
    }

    public void delete(int id) {
        medicineService.deleteMedicine(id);
    }
}
