package com.farmacy.city.application;

import com.farmacy.city.domain.entity.City;
import com.farmacy.city.domain.service.CityService;

import java.util.List;

public class ListAllCitiesUC {
    private final CityService cityService;

    public ListAllCitiesUC(CityService cityService) {
        this.cityService = cityService;
    }

    public List<City> listAll() {
        return cityService.listAllCities();
    }
}