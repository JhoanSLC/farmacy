package com.farmacy.modeAdministration.application;

import java.util.List;
import com.farmacy.modeAdministration.domain.entitiy.ModeAdministration;
import com.farmacy.modeAdministration.domain.service.ModeAdService;

public class ListAllModeAdUC {
    private final ModeAdService modeAdService;

    public ListAllModeAdUC(ModeAdService modeAdService) {
        this.modeAdService = modeAdService;
    }

    public List<ModeAdministration> listAll() {
        return modeAdService.listAllModeAd();
    }
}
