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
        System.out.println("Ingrese el código de la ciudad:");
        String codeCity = scan.nextLine();
        System.out.println("Ingrese el nombre de la ciudad:");
        String nameCity = scan.nextLine();
        System.out.println("Ingrese el código de la región:");
        String codeReg = scan.nextLine();
        City city = new City(codeCity, nameCity, codeReg);
        createCityUC.create(city);
        System.out.println("Ciudad creada exitosamente.");
    }

    public void deleteCity() {
        screen.clean();
        System.out.println("Ingrese el código de la ciudad a eliminar:");
        String codeCity = scan.nextLine();
        deleteCityUC.delete(codeCity);
        System.out.println("Ciudad eliminada exitosamente.");
    }

    public void findCityById() {
        screen.clean();
        System.out.println("Ingrese el código de la ciudad a buscar:");
        String codeCity = scan.nextLine();
        Optional<City> city = findCityByIdUC.findById(codeCity);
        city.ifPresentOrElse(
            c -> System.out.println("Ciudad encontrada: " + c.getNameCity() + " (" + c.getCodeCity() + ")"),
            () -> System.out.println("Ciudad no encontrada.")
        );
        screen.pause();
    }

    public void updateCity() {
        screen.clean();
        System.out.println("Ingrese el código de la ciudad a actualizar:");
        String codeCity = scan.nextLine();
        System.out.println("Ingrese el nuevo nombre de la ciudad:");
        String nameCity = scan.nextLine();
        System.out.println("Ingrese el nuevo código de la región:");
        String codeReg = scan.nextLine();
        updateCityUC.update(codeCity, nameCity, codeReg);
        System.out.println("Ciudad actualizada exitosamente.");
    }

    public void listAllCities() {
        screen.clean();
        List<City> cities = listAllCitiesUC.listAll();
        cities.forEach(city -> System.out.println(city.getCodeCity() + " - " + city.getNameCity()));
        screen.pause();
    }

}
