package com.farmacy.labatory.application;

import com.farmacy.labatory.domain.entity.Labatory;
import com.farmacy.labatory.domain.service.LabatoryService;

import java.util.List;

public class ListAllLabatoriesUC {
    private final LabatoryService labatoryService;

    public ListAllLabatoriesUC(LabatoryService labatoryService) {
        this.labatoryService = labatoryService;
    }

    public List<Labatory> listAll() {
        return labatoryService.listAllLabatories();
    }
}
