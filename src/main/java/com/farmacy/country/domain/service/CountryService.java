package com.farmacy.country.domain.service;

import com.farmacy.country.domain.entity.Country;

import java.util.List;
import java.util.Optional;

public interface CountryService {
    void createCountry(Country country);
    Optional<Country> findCountryById(String codeCountry);
    void updateCountry(String codeCountry, String nameCountry);
    void deleteCountry(String codeCountry);
    List<Country> listAllCountries();
}
