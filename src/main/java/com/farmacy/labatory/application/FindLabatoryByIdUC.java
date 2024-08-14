package com.farmacy.labatory.application;

import com.farmacy.labatory.domain.entity.Labatory;
import com.farmacy.labatory.domain.service.LabatoryService;

import java.util.Optional;

public class FindLabatoryByIdUC {
    private final LabatoryService labatoryService;

    public FindLabatoryByIdUC(LabatoryService labatoryService) {
        this.labatoryService = labatoryService;
    }

    public Optional<Labatory> findById(int id) {
        return labatoryService.findLabatoryById(id);
    }
}
