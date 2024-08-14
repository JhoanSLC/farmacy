package com.farmacy.medicine.domain.service;

import com.farmacy.medicine.domain.entity.Medicine;

import java.util.List;
import java.util.Optional;

public interface MedicineService {
    void createMedicine(Medicine medicine);
    Optional<Medicine> findMedicineById(int id);
    void updateMedicine(int id, String nameMedicine, String descriptionShort, String descriptionLong);
    void deleteMedicine(int id);
    List<Medicine> listAllMedicines();
}
