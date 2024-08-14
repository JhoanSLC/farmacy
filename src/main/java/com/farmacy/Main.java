package com.farmacy;

import com.farmacy.modeAdministration.infrastructure.controller.ModeAdController;
import com.farmacy.ui.MainUi;
import com.farmacy.unitMeasurement.infrastructure.controller.UnitMeController;

public class Main {
    public static void main(String[] args) {
        UnitMeController ume = new UnitMeController();

        ume.deleteUnitMeasurement();
    }
}