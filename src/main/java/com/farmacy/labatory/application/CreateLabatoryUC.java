package com.farmacy.labatory.application;

import com.farmacy.labatory.domain.entity.Labatory;
import com.farmacy.labatory.domain.service.LabatoryService;

public class CreateLabatoryUC {
    private final LabatoryService labatoryService;

    public CreateLabatoryUC(LabatoryService labatoryService) {
        this.labatoryService = labatoryService;
    }

    public void create(Labatory labatory) {
        labatoryService.createLabatory(labatory);
    }
}
