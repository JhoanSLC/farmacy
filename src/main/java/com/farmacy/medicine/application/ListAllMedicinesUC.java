package com.farmacy.medicine.application;

import com.farmacy.medicine.domain.entity.Medicine;
import com.farmacy.medicine.domain.service.MedicineService;

import java.util.List;

public class ListAllMedicinesUC {
    private final MedicineService medicineService;

    public ListAllMedicinesUC(MedicineService medicineService) {
        this.medicineService = medicineService;
    }

    public List<Medicine> listAll() {
        return medicineService.listAllMedicines();
    }
}
