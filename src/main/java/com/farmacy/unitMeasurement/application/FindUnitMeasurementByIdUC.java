package com.farmacy.unitMeasurement.application;

import java.util.Optional;

import com.farmacy.unitMeasurement.domain.entity.UnitMeasurement;
import com.farmacy.unitMeasurement.domain.service.UnitMeasurementService;

public class FindUnitMeasurementByIdUC {
        private final UnitMeasurementService unitMeasurementService;

    public FindUnitMeasurementByIdUC(UnitMeasurementService unitMeasurementService) {
        this.unitMeasurementService = unitMeasurementService;
    }

    public Optional<UnitMeasurement> findById(long id) {
        return unitMeasurementService.findUnitMeasurementById(id);
    }
}
