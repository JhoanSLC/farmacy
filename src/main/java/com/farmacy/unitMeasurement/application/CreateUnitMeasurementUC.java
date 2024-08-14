package com.farmacy.unitMeasurement.application;

import com.farmacy.unitMeasurement.domain.entity.UnitMeasurement;
import com.farmacy.unitMeasurement.domain.service.UnitMeasurementService;

public class CreateUnitMeasurementUC {
        private final UnitMeasurementService unitMeasurementService;

    public CreateUnitMeasurementUC(UnitMeasurementService unitMeasurementService) {
        this.unitMeasurementService = unitMeasurementService;
    }

    public void create(UnitMeasurement unitMeasurement) {
        unitMeasurementService.createUnitMeasurement(unitMeasurement);
    }
}
