package com.farmacy.city.domain.service;

import com.farmacy.city.domain.entity.City;
import java.util.List;
import java.util.Optional;

public interface CityService {
    void createCity(City city);
    Optional<City> findCityById(String codeCity);
    void updateCity(String codeCity, String nameCity, String codeReg);
    void deleteCity(String codeCity);
    List<City> listAllCities();
}
