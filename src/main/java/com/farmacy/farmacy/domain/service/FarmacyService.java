package com.farmacy.farmacy.domain.service;

import com.farmacy.farmacy.domain.entity.Farmacy;

import java.util.List;
import java.util.Optional;

public interface FarmacyService {
    void createFarmacy(Farmacy farmacy);
    Optional<Farmacy> findFarmacyById(int idFarmacy);
    void updateFarmacy(int idFarmacy, String nameFarmacy, String addressFarmacy, double lonFarmacy, double latFarmacy, String logoFarmacy);
    void deleteFarmacy(int idFarmacy);
    List<Farmacy> listAllFarmacies();
}
