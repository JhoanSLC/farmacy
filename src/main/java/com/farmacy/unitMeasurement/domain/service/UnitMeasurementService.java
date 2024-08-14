package com.farmacy.unitMeasurement.domain.service;

import java.util.Optional;
import java.util.List;

import com.farmacy.unitMeasurement.domain.entity.UnitMeasurement;

public interface UnitMeasurementService {
    void createUnitMeasurement(UnitMeasurement unitMeasurement);
    Optional<UnitMeasurement> findUnitMeasurementById(long id);
    void updateUnitMeasurement(long id, String nameUm);
    void deleteUnitMeasurement(long id);
    List<UnitMeasurement> listAllUnitMeasurement();
}
