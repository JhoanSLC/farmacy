package com.farmacy.activePrinciple.application;

import java.util.List;
import com.farmacy.activePrinciple.domain.entity.ActivePrinciple;
import com.farmacy.activePrinciple.domain.service.ActivePrincipleService;

public class ListAllActivePrinciplesUC {
    private final ActivePrincipleService activePrincipleService;

    public ListAllActivePrinciplesUC(ActivePrincipleService activePrincipleService) {
        this.activePrincipleService = activePrincipleService;
    }

    public List<ActivePrinciple> listAll() {
        return activePrincipleService.findAllActivePrinciples();
    }
}
