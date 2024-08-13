package com.farmacy.modeAdministration.domain.service;

import java.util.Optional;

import com.farmacy.modeAdministration.domain.entitiy.ModeAdministration;

public interface ModeAdministrationService {
    void createModeAd(ModeAdministration modeAd);
    Optional<ModeAdministration> findModeAdById(Long id);
    void updateModeAd(Long id);
    void deleteModeAd(Long id);
}
