package com.farmacy.activePrinciple.application;

import com.farmacy.activePrinciple.domain.service.ActivePrincipleService;

public class DeleteActivePrincipleUC {
    private final ActivePrincipleService activePrincipleService;

    public DeleteActivePrincipleUC(ActivePrincipleService activePrincipleService) {
        this.activePrincipleService = activePrincipleService;
    }

    public void delete(long idAp) {
        activePrincipleService.deleteActivePrinciple(idAp);
    }
}
