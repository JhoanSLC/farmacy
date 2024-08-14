package com.farmacy.activePrinciple.application;

import com.farmacy.activePrinciple.domain.entity.ActivePrinciple;
import com.farmacy.activePrinciple.domain.service.ActivePrincipleService;

public class CreateActivePrincipleUC {
    private final ActivePrincipleService activePrincipleService;

    public CreateActivePrincipleUC(ActivePrincipleService activePrincipleService) {
        this.activePrincipleService = activePrincipleService;
    }

    public void create(ActivePrinciple activePrinciple) {
        activePrincipleService.createActivePrinciple(activePrinciple);
    }
}
