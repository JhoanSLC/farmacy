package com.farmacy.country.application;

import com.farmacy.country.domain.service.CountryService;

public class UpdateCountryUC {
    private final CountryService countryService;

    public UpdateCountryUC(CountryService countryService) {
        this.countryService = countryService;
    }

    public void update(String codeCountry, String nameCountry) {
        countryService.updateCountry(codeCountry, nameCountry);
    }
}
