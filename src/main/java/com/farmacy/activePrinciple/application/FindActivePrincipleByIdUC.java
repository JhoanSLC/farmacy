package com.farmacy.activePrinciple.application;

import java.util.Optional;
import com.farmacy.activePrinciple.domain.entity.ActivePrinciple;
import com.farmacy.activePrinciple.domain.service.ActivePrincipleService;

public class FindActivePrincipleByIdUC {
    private final ActivePrincipleService activePrincipleService;

    public FindActivePrincipleByIdUC(ActivePrincipleService activePrincipleService) {
        this.activePrincipleService = activePrincipleService;
    }

    public Optional<ActivePrinciple> findById(long idAp) {
        return activePrincipleService.findActivePrincipleById(idAp);
    }
}
