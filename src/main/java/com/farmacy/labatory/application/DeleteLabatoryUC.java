package com.farmacy.labatory.application;

import com.farmacy.labatory.domain.service.LabatoryService;

public class DeleteLabatoryUC {
    private final LabatoryService labatoryService;

    public DeleteLabatoryUC(LabatoryService labatoryService) {
        this.labatoryService = labatoryService;
    }

    public void delete(int id) {
        labatoryService.deleteLabatory(id);
    }
}
