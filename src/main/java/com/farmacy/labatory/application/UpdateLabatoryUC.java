package com.farmacy.labatory.application;

import com.farmacy.labatory.domain.service.LabatoryService;

public class UpdateLabatoryUC {
    private final LabatoryService labatoryService;

    public UpdateLabatoryUC(LabatoryService labatoryService) {
        this.labatoryService = labatoryService;
    }

    public void update(int id, String nameLab) {
        labatoryService.updateLabatory(id, nameLab);
    }
}
