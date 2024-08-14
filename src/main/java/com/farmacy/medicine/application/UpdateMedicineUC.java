package com.farmacy.medicine.application;

import com.farmacy.medicine.domain.service.MedicineService;

public class UpdateMedicineUC {
    private final MedicineService medicineService;

    public UpdateMedicineUC(MedicineService medicineService) {
        this.medicineService = medicineService;
    }

    public void update(int id, String nameMedicine, String descriptionShort, String descriptionLong) {
        medicineService.updateMedicine(id, nameMedicine, descriptionShort, descriptionLong);
    }
}
