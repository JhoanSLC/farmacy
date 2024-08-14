package com.farmacy.city.application;

import com.farmacy.city.domain.service.CityService;

public class DeleteCityUC {
    private final CityService cityService;

    public DeleteCityUC(CityService cityService) {
        this.cityService = cityService;
    }

    public void delete(String codeCity) {
        cityService.deleteCity(codeCity);
    }
}