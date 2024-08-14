package com.farmacy.city.application;

import com.farmacy.city.domain.entity.City;
import com.farmacy.city.domain.service.CityService;

import java.util.Optional;

public class FindCityByIdUC {
    private final CityService cityService;

    public FindCityByIdUC(CityService cityService) {
        this.cityService = cityService;
    }

    public Optional<City> findById(String codeCity) {
        return cityService.findCityById(codeCity);
    }
}