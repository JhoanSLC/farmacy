package com.farmacy.farmacy.infrastructure.repository;

import com.farmacy.farmacy.domain.entity.Farmacy;
import com.farmacy.farmacy.domain.service.FarmacyService;
import com.farmacy.database.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class FarmacyRepository implements FarmacyService {
    private final DatabaseConnection databaseConnection = new DatabaseConnection();

    @Override
    public void createFarmacy(Farmacy farmacy) {
        String query = "INSERT INTO farmacy (nameFarmacy, addressFarmacy, lonFarmacy, latFarmacy, codeCityFarm, logoFarmacy) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection con = databaseConnection.connectDatabase();
            PreparedStatement stmt = con.prepareStatement(query)) {
            stmt.setString(1, farmacy.getNameFarmacy());
            stmt.setString(2, farmacy.getAddressFarmacy());
            stmt.setDouble(3, farmacy.getLonFarmacy());
            stmt.setDouble(4, farmacy.getLatFarmacy());
            stmt.setString(5, farmacy.getCodeCityFarm());
            stmt.setString(6, farmacy.getLogoFarmacy());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Optional<Farmacy> findFarmacyById(int idFarmacy) {
        String query = "SELECT * FROM farmacy WHERE idFarmacy = ?";
        try (Connection con = databaseConnection.connectDatabase();
             PreparedStatement stmt = con.prepareStatement(query)) {
            stmt.setInt(1, idFarmacy);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Farmacy farmacy = new Farmacy();
                farmacy.setIdFarmacy(rs.getInt("idFarmacy"));
                farmacy.setNameFarmacy(rs.getString("nameFarmacy"));
                farmacy.setAddressFarmacy(rs.getString("addressFarmacy"));
                farmacy.setLonFarmacy(rs.getDouble("lonFarmacy"));
                farmacy.setLatFarmacy(rs.getDouble("latFarmacy"));
                farmacy.setCodeCityFarm(rs.getString("codeCityFarm"));
                farmacy.setLogoFarmacy(rs.getString("logoFarmacy"));
                return Optional.of(farmacy);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public void updateFarmacy(int idFarmacy, String nameFarmacy, String addressFarmacy, double lonFarmacy, double latFarmacy, String logoFarmacy) {
        String query = "UPDATE farmacy SET nameFarmacy = ?, addressFarmacy = ?, lonFarmacy = ?, latFarmacy = ?, logoFarmacy = ? WHERE idFarmacy = ?";
        try (Connection con = databaseConnection.connectDatabase();
             PreparedStatement stmt = con.prepareStatement(query)) {
            stmt.setString(1, nameFarmacy);
            stmt.setString(2, addressFarmacy);
            stmt.setDouble(3, lonFarmacy);
            stmt.setDouble(4, latFarmacy);
            stmt.setString(5, logoFarmacy);
            stmt.setInt(6, idFarmacy);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteFarmacy(int idFarmacy) {
        String query = "DELETE FROM farmacy WHERE idFarmacy = ?";
        try (Connection con = databaseConnection.connectDatabase();
             PreparedStatement stmt = con.prepareStatement(query)) {
            stmt.setInt(1, idFarmacy);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Farmacy> listAllFarmacies() {
        List<Farmacy> farmacies = new ArrayList<>();
        String query = "SELECT * FROM farmacy";
        try (Connection con = databaseConnection.connectDatabase();
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                Farmacy farmacy = new Farmacy();
                farmacy.setIdFarmacy(rs.getInt("idFarmacy"));
                farmacy.setNameFarmacy(rs.getString("nameFarmacy"));
                farmacy.setAddressFarmacy(rs.getString("addressFarmacy"));
                farmacy.setLonFarmacy(rs.getDouble("lonFarmacy"));
                farmacy.setLatFarmacy(rs.getDouble("latFarmacy"));
                farmacy.setCodeCityFarm(rs.getString("codeCityFarm"));
                farmacy.setLogoFarmacy(rs.getString("logoFarmacy"));
                farmacies.add(farmacy);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return farmacies;
    }
}
