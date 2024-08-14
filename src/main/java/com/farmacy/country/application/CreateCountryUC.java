package com.farmacy.country.application;

import com.farmacy.country.domain.entity.Country;
import com.farmacy.country.domain.service.CountryService;

public class CreateCountryUC {
    private final CountryService countryService;

    public CreateCountryUC(CountryService countryService) {
        this.countryService = countryService;
    }

    public void create(Country country) {
        countryService.createCountry(country);
    }
}
