package com.farmacy.unitMeasurement.application;

import com.farmacy.unitMeasurement.domain.service.UnitMeasurementService;
import com.farmacy.unitMeasurement.domain.entity.UnitMeasurement;
import java.util.List;

public class ListAllUnitMeasurementsUC {
    private final UnitMeasurementService unitMeasurementService;

    public ListAllUnitMeasurementsUC(UnitMeasurementService unitMeasurementService) {
        this.unitMeasurementService = unitMeasurementService;
    }

    public List<UnitMeasurement> listAll() {
        return unitMeasurementService.listAllUnitMeasurement();
    }
}
