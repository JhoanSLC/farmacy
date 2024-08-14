package com.farmacy.labatory.domain.service;

import com.farmacy.labatory.domain.entity.Labatory;

import java.util.List;
import java.util.Optional;

public interface LabatoryService {
    void createLabatory(Labatory labatory);
    Optional<Labatory> findLabatoryById(int id);
    void updateLabatory(int id, String nameLab);
    void deleteLabatory(int id);
    List<Labatory> listAllLabatories();
}
