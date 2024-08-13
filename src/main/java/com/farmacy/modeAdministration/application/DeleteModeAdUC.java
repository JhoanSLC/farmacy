package com.farmacy.modeAdministration.application;

import com.farmacy.modeAdministration.domain.service.ModeAdService;

public class DeleteModeAdUC {
    private final ModeAdService modeAdService;

    public DeleteModeAdUC(ModeAdService modeAdService){
        this.modeAdService = modeAdService;
    }

    public void delete(long id){
        modeAdService.deleteModeAd(id);
    }
}
