package com.farmacy.activePrinciple.application;

import com.farmacy.activePrinciple.domain.service.ActivePrincipleService;

public class UpdateActivePrincipleUC {
    private final ActivePrincipleService activePrincipleService;

    public UpdateActivePrincipleUC(ActivePrincipleService activePrincipleService) {
        this.activePrincipleService = activePrincipleService;
    }

    public void update(long idAp, String nameAp) {
        activePrincipleService.updateActivePrinciple(idAp, nameAp);
    }
}
