package com.farmacy.city.application;

import com.farmacy.city.domain.service.CityService;

public class UpdateCityUC {
    private final CityService cityService;

    public UpdateCityUC(CityService cityService) {
        this.cityService = cityService;
    }

    public void update(String codeCity, String nameCity, String codeReg) {
        cityService.updateCity(codeCity, nameCity, codeReg);
    }
}