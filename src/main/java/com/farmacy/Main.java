package com.farmacy;

import com.farmacy.modeAdministration.infrastructure.controller.ModeAdController;
import com.farmacy.ui.MainUi;

public class Main {
    public static void main(String[] args) {
        ModeAdController modeAd = new ModeAdController();

        modeAd.updateModeAd();
    }
}