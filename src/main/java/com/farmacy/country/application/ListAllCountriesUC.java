package com.farmacy.country.application;

import com.farmacy.country.domain.entity.Country;
import com.farmacy.country.domain.service.CountryService;

import java.util.List;

public class ListAllCountriesUC {
    private final CountryService countryService;

    public ListAllCountriesUC(CountryService countryService) {
        this.countryService = countryService;
    }

    public List<Country> listAll() {
        return countryService.listAllCountries();
    }
}
