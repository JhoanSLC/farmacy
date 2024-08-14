package com.farmacy.country.infrastructure.repository;

import com.farmacy.country.domain.entity.Country;
import com.farmacy.country.domain.service.CountryService;
import com.farmacy.database.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CountryRepository implements CountryService {
    private final DatabaseConnection databaseConnection = new DatabaseConnection();

    @Override
    public void createCountry(Country country) {
        String query = "INSERT INTO country (codeCountry, nameCountry) VALUES (?, ?)";
        try (Connection con = databaseConnection.connectDatabase();
             PreparedStatement stmt = con.prepareStatement(query)) {
            stmt.setString(1, country.getCodeCountry());
            stmt.setString(2, country.getNameCountry());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Optional<Country> findCountryById(String codeCountry) {
        String query = "SELECT * FROM country WHERE codeCountry = ?";
        try (Connection con = databaseConnection.connectDatabase();
             PreparedStatement stmt = con.prepareStatement(query)) {
            stmt.setString(1, codeCountry);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Country country = new Country();
                country.setCodeCountry(rs.getString("codeCountry"));
                country.setNameCountry(rs.getString("nameCountry"));
                return Optional.of(country);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public void updateCountry(String codeCountry, String nameCountry) {
        String query = "UPDATE country SET nameCountry = ? WHERE codeCountry = ?";
        try (Connection con = databaseConnection.connectDatabase();
             PreparedStatement stmt = con.prepareStatement(query)) {
            stmt.setString(1, nameCountry);
            stmt.setString(2, codeCountry);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteCountry(String codeCountry) {
        String query = "DELETE FROM country WHERE codeCountry = ?";
        try (Connection con = databaseConnection.connectDatabase();
             PreparedStatement stmt = con.prepareStatement(query)) {
            stmt.setString(1, codeCountry);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Country> listAllCountries() {
        List<Country> countries = new ArrayList<>();
        String query = "SELECT * FROM country";
        try (Connection con = databaseConnection.connectDatabase();
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                Country country = new Country();
                country.setCodeCountry(rs.getString("codeCountry"));
                country.setNameCountry(rs.getString("nameCountry"));
                countries.add(country);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return countries;
    }
}
