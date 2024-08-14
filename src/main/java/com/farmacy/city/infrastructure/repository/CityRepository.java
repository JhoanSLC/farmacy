package com.farmacy.city.infrastructure.repository;

import com.farmacy.database.DatabaseConnection;
import com.farmacy.city.domain.entity.City;
import com.farmacy.city.domain.service.CityService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CityRepository implements CityService {
    private Connection con;

    public CityRepository() {
        DatabaseConnection database = new DatabaseConnection();
        con = database.connectDatabase();
    }

    @Override
    public void createCity(City city) {
        String insertCity = "INSERT INTO city (codeCity, nameCity, codeReg) VALUES (?, ?, ?)";

        try (PreparedStatement ps = con.prepareStatement(insertCity)) {
            ps.setString(1, city.getCodeCity());
            ps.setString(2, city.getNameCity());
            ps.setString(3, city.getCodeReg());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Optional<City> findCityById(String codeCity) {
        String findByIdQuery = "SELECT codeCity, nameCity, codeReg FROM city WHERE codeCity = ?";
        try (PreparedStatement ps = con.prepareStatement(findByIdQuery)) {
            ps.setString(1, codeCity);

            try (ResultSet set = ps.executeQuery()) {
                if (set.next()) {
                    String resultCodeCity = set.getString("codeCity");
                    String resultNameCity = set.getString("nameCity");
                    String resultCodeReg = set.getString("codeReg");

                    City city = new City(resultCodeCity, resultNameCity, resultCodeReg);
                    return Optional.of(city);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public void updateCity(String codeCity, String nameCity, String codeReg) {
        String updateQuery = "UPDATE city SET nameCity = ?, codeReg = ? WHERE codeCity = ?";
        try (PreparedStatement ps = con.prepareStatement(updateQuery)) {
            ps.setString(1, nameCity);
            ps.setString(2, codeReg);
            ps.setString(3, codeCity);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteCity(String codeCity) {
        String deleteCity = "DELETE FROM city WHERE codeCity = ?";
        try (PreparedStatement ps = con.prepareStatement(deleteCity)) {
            ps.setString(1, codeCity);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<City> listAllCities() {
        List<City> cities = new ArrayList<>();
        String query = "SELECT codeCity, nameCity, codeReg FROM city";
        try (PreparedStatement ps = con.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                String codeCity = rs.getString("codeCity");
                String nameCity = rs.getString("nameCity");
                String codeReg = rs.getString("codeReg");
                cities.add(new City(codeCity, nameCity, codeReg));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cities;
    }
}
