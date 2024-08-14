package com.farmacy.modeAdministration.application;

import java.util.Optional;

import com.farmacy.modeAdministration.domain.entitiy.ModeAdministration;
import com.farmacy.modeAdministration.domain.service.ModeAdService;

public class FindModeByIdUC {
    private ModeAdService modeAdService;

    public FindModeByIdUC(ModeAdService mode){
        this.modeAdService = mode;
    }

    public Optional<ModeAdministration> findById(long id){
        return modeAdService.findModeAdById(id);
    }
}
