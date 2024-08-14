package com.farmacy.unitMeasurement.application;

import com.farmacy.unitMeasurement.domain.service.UnitMeasurementService;

public class DeleteUnitMeasurementUC {
        private final UnitMeasurementService unitMeasurementService;

    public DeleteUnitMeasurementUC(UnitMeasurementService unitMeasurementService) {
        this.unitMeasurementService = unitMeasurementService;
    }

    public void delete(long id) {
        unitMeasurementService.deleteUnitMeasurement(id);
    }
}
