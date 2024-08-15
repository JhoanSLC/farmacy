package com.farmacy.city.infrastructure.controller;

import com.farmacy.city.application.CreateCityUC;
import com.farmacy.city.application.DeleteCityUC;
import com.farmacy.city.application.FindCityByIdUC;
import com.farmacy.city.application.ListAllCitiesUC;
import com.farmacy.city.application.UpdateCityUC;
import com.farmacy.city.domain.entity.City;
import com.farmacy.city.domain.service.CityService;
import com.farmacy.city.infrastructure.repository.CityRepository;
import com.farmacy.screen.ScreenController;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class CityController {
    private final CityService cityService;
    private final CreateCityUC createCityUC;
    private final DeleteCityUC deleteCityUC;
    private final FindCityByIdUC findCityByIdUC;
    private final UpdateCityUC updateCityUC;
    private final ListAllCitiesUC listAllCitiesUC;
    private final Scanner scan = new Scanner(System.in);
    private final ScreenController screen = new ScreenController();

    public CityController() {
        this.cityService = new CityRepository();
        this.createCityUC = new CreateCityUC(cityService);
        this.deleteCityUC = new DeleteCityUC(cityService);
        this.findCityByIdUC = new FindCityByIdUC(cityService);
        this.updateCityUC = new UpdateCityUC(cityService);
        this.listAllCitiesUC = new ListAllCitiesUC(cityService);
    }

    public void createCity() {
        screen.clean();
        System.out.println("Enter the city code:");
        String codeCity = scan.nextLine();
        System.out.println("Enter the city name:");
        String nameCity = scan.nextLine();
        System.out.println("Enter the region code:");
        String codeReg = scan.nextLine();
        City city = new City(codeCity, nameCity, codeReg);
        createCityUC.create(city);
        System.out.println("City created successfully.");
    }

    public void deleteCity() {
        screen.clean();
        System.out.println("Enter the code of the city to delete:");
        String codeCity = scan.nextLine();
        deleteCityUC.delete(codeCity);
        System.out.println("City deleted successfully.");
    }

    public void findCityById() {
        screen.clean();
        System.out.println("Enter the code of the city to search:");
        String codeCity = scan.nextLine();
        Optional<City> city = findCityByIdUC.findById(codeCity);
        city.ifPresentOrElse(
            c -> System.out.printf("%ncityCode: %s%nName: %s%ncodeRegion: %s%n",c.getCodeCity(),c.getNameCity(),c.getCodeReg()),
            () -> System.out.println("City not found.")
        );
        screen.pause();
    }

    public void updateCity() {
        screen.clean();
        System.out.println("Enter the code of the city to update:");
        String codeCity = scan.nextLine();
        System.out.println("Enter the new city name:");
        String nameCity = scan.nextLine();
        System.out.println("Enter the new region code:");
        String codeReg = scan.nextLine();
        updateCityUC.update(codeCity, nameCity, codeReg);
        System.out.println("City updated successfully.");
    }

    public void listAllCities() {
        screen.clean();
        List<City> cities = listAllCitiesUC.listAll();
        cities.forEach(city -> System.out.printf("%ncityCode: %s%nName: %s%ncodeRegion: %s%n",city.getCodeCity(),city.getNameCity(),city.getCodeReg()));
        screen.pause();
    }

}
