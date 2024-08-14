package com.farmacy.activePrinciple.domain.service;

import com.farmacy.activePrinciple.domain.entity.ActivePrinciple;
import java.util.Optional;
import java.util.List;

public interface ActivePrincipleService {
    void createActivePrinciple(ActivePrinciple activePrinciple);
    Optional<ActivePrinciple> findActivePrincipleById(long id);
    void updateActivePrinciple(long id, String nameAp);
    void deleteActivePrinciple(long id);
    List<ActivePrinciple> findAllActivePrinciples();

}
