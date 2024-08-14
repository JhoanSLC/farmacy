package com.farmacy.modeAdministration.domain.service;

import java.util.Optional;

import com.farmacy.modeAdministration.domain.entitiy.ModeAdministration;
import java.util.List;

public interface ModeAdService {
    void createModeAd(ModeAdministration modeAd);
    Optional<ModeAdministration> findModeAdById(long id);
    void updateModeAd(long id, String description);
    void deleteModeAd(long id);
    List<ModeAdministration> listAllModeAd();
}
