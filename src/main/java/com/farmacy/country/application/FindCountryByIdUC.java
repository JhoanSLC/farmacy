package com.farmacy.country.application;

import com.farmacy.country.domain.entity.Country;
import com.farmacy.country.domain.service.CountryService;

import java.util.Optional;

public class FindCountryByIdUC {
    private final CountryService countryService;

    public FindCountryByIdUC(CountryService countryService) {
        this.countryService = countryService;
    }

    public Optional<Country> findById(String codeCountry) {
        return countryService.findCountryById(codeCountry);
    }
}
