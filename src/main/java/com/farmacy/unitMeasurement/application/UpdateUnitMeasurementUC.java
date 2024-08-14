package com.farmacy.unitMeasurement.application;

import com.farmacy.unitMeasurement.domain.service.UnitMeasurementService;

public class UpdateUnitMeasurementUC {
        private final UnitMeasurementService unitMeasurementService;

    public UpdateUnitMeasurementUC(UnitMeasurementService unitMeasurementService) {
        this.unitMeasurementService = unitMeasurementService;
    }

    public void update(long id, String nameUm) {
        unitMeasurementService.updateUnitMeasurement(id, nameUm);
    }
}
