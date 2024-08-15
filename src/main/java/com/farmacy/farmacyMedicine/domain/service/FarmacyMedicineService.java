package com.farmacy.farmacyMedicine.domain.service;

import com.farmacy.farmacyMedicine.domain.entity.FarmacyMedicine;

import java.util.List;
import java.util.Optional;

public interface FarmacyMedicineService {
    void createFarmacyMedicine(FarmacyMedicine farmacyMedicine);
    Optional<FarmacyMedicine> findFarmacyMedicineById(int id);
    void updateFarmacyMedicine(int id, double price);
    void deleteFarmacyMedicine(int id);
    List<FarmacyMedicine> listAllFarmacyMedicines();
}
