package com.farmacy.country.application;

import com.farmacy.country.domain.service.CountryService;

public class DeleteCountryUC {
    private final CountryService countryService;

    public DeleteCountryUC(CountryService countryService) {
        this.countryService = countryService;
    }

    public void delete(String codeCountry) {
        countryService.deleteCountry(codeCountry);
    }
}
