package com.farmacy.modeAdministration.application;

import com.farmacy.modeAdministration.domain.entitiy.ModeAdministration;
import com.farmacy.modeAdministration.domain.service.ModeAdService;

public class CreateModeAdUC {
    private final ModeAdService modeAdService;

    public CreateModeAdUC(ModeAdService modeAdService){
        this.modeAdService = modeAdService;
    }

    public void create(ModeAdministration modeAd){
        modeAdService.createModeAd(modeAd);
    }
}
