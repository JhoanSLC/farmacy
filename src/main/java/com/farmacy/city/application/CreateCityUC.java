package com.farmacy.city.application;

import com.farmacy.city.domain.entity.City;
import com.farmacy.city.domain.service.CityService;

public class CreateCityUC {
    private final CityService cityService;

    public CreateCityUC(CityService cityService) {
        this.cityService = cityService;
    }

    public void create(City city) {
        cityService.createCity(city);
    }
}