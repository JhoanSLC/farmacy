package com.farmacy;

import com.farmacy.modeAdministration.infrastructure.controller.ModeAdController;

public class Main {
    public static void main(String[] args) {
        ModeAdController modeAdController = new ModeAdController();

        modeAdController.deleteModeAd();
    }
}