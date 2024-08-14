package com.farmacy.modeAdministration.application;

import com.farmacy.modeAdministration.domain.service.ModeAdService;

public class UpdateModeAdUC {
    private final ModeAdService modeAdService;

    public UpdateModeAdUC(ModeAdService mode){
        this.modeAdService = mode;
    }

    public void update(long id, String description){
        modeAdService.updateModeAd(id, description);
    }
}
