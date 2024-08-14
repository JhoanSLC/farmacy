package com.farmacy.country.infrastructure.controller;

import com.farmacy.country.application.*;
import com.farmacy.country.domain.entity.Country;
import com.farmacy.country.domain.service.CountryService;
import com.farmacy.country.infrastructure.repository.CountryRepository;
import com.farmacy.screen.ScreenController;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class CountryController {
    private final CountryService countryService;
    private final CreateCountryUC createCountryUC;
    private final DeleteCountryUC deleteCountryUC;
    private final FindCountryByIdUC findCountryByIdUC;
    private final UpdateCountryUC updateCountryUC;
    private final ListAllCountriesUC listAllCountriesUC;
    private final Scanner scan = new Scanner(System.in);
    private final ScreenController screen = new ScreenController();

    public CountryController() {
        this.countryService = new CountryRepository();
        this.createCountryUC = new CreateCountryUC(countryService);
        this.deleteCountryUC = new DeleteCountryUC(countryService);
        this.findCountryByIdUC = new FindCountryByIdUC(countryService);
        this.updateCountryUC = new UpdateCountryUC(countryService);
        this.listAllCountriesUC = new ListAllCountriesUC(countryService);
    }

    public void createCountry() {
        screen.clean();
        System.out.println("Type the code of the country");
        String codeCountry = scan.nextLine();
        System.out.println("Type the name of the country");
        String nameCountry = scan.nextLine();

        Country country = new Country();
        country.setCodeCountry(codeCountry);
        country.setNameCountry(nameCountry);

        createCountryUC.create(country);
    }

    public void deleteCountry() {
        screen.clean();
        System.out.println("Type the code of the country you want to delete");
        String codeCountry = scan.nextLine();
        deleteCountryUC.delete(codeCountry);
    }

    public void findCountryById() {
        screen.clean();
        System.out.println("Type the code of the country you want to see");
        String codeCountry = scan.nextLine();
        Optional<Country> country = findCountryByIdUC.findById(codeCountry);

        country.ifPresentOrElse(
            c -> System.out.printf("%nCode: %s%nName: %s%n", c.getCodeCountry(), c.getNameCountry()),
            () -> System.out.println("Country not found.")
        );
        screen.pause();
    }

    public void updateCountry() {
        screen.clean();
        System.out.println("Type the code of the country you want to update");
        String codeCountry = scan.nextLine();
        System.out.println("Type the new name for this country");
        String nameCountry = scan.nextLine();
        updateCountryUC.update(codeCountry, nameCountry);
    }

    public void listAllCountries() {
        screen.clean();
        System.out.println("Listing all countries:");
        List<Country> countries = listAllCountriesUC.listAll();

        if (countries.isEmpty()) {
            System.out.println("No countries found.");
        } else {
            for (Country country : countries) {
                System.out.println("");
                System.out.printf("Code: %s%nName: %s%n", country.getCodeCountry(), country.getNameCountry());
            }
        }
        System.out.printf("%nPress any key to continue...");
        scan.nextLine();
    }
}
