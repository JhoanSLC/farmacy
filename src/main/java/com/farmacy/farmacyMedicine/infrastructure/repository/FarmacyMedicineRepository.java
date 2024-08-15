package com.farmacy.farmacyMedicine.infrastructure.repository;

import com.farmacy.farmacyMedicine.domain.entity.FarmacyMedicine;
import com.farmacy.farmacyMedicine.domain.service.FarmacyMedicineService;
import com.farmacy.database.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class FarmacyMedicineRepository implements FarmacyMedicineService {
    private final DatabaseConnection databaseConnection = new DatabaseConnection();

    @Override
    public void createFarmacyMedicine(FarmacyMedicine farmacyMedicine) {
        String query = "INSERT INTO farmacyMedicine (idFarmacy, idMedicineFatrm, price) VALUES (?, ?, ?)";
        try (Connection con = databaseConnection.connectDatabase();
            PreparedStatement stmt = con.prepareStatement(query)) {
            stmt.setInt(1, farmacyMedicine.getIdFarmacy());
            stmt.setInt(2, farmacyMedicine.getIdMedicineFatrm());
            stmt.setDouble(3, farmacyMedicine.getPrice());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Optional<FarmacyMedicine> findFarmacyMedicineById(int id) {
        String query = "SELECT * FROM farmacyMedicine WHERE idFarmacyMedicine = ?";
        try (Connection con = databaseConnection.connectDatabase();
             PreparedStatement stmt = con.prepareStatement(query)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                FarmacyMedicine farmacyMedicine = new FarmacyMedicine();
                farmacyMedicine.setIdFarmacyMedicine(rs.getInt("idFarmacyMedicine"));
                farmacyMedicine.setIdFarmacy(rs.getInt("idFarmacy"));
                farmacyMedicine.setIdMedicineFatrm(rs.getInt("idMedicineFatrm"));
                farmacyMedicine.setPrice(rs.getDouble("price"));
                return Optional.of(farmacyMedicine);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public void updateFarmacyMedicine(int id, double price) {
        String query = "UPDATE farmacyMedicine SET price = ? WHERE idFarmacyMedicine = ?";
        try (Connection con = databaseConnection.connectDatabase();
             PreparedStatement stmt = con.prepareStatement(query)) {
            stmt.setDouble(1, price);
            stmt.setInt(2, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteFarmacyMedicine(int id) {
        String query = "DELETE FROM farmacyMedicine WHERE idFarmacyMedicine = ?";
        try (Connection con = databaseConnection.connectDatabase();
             PreparedStatement stmt = con.prepareStatement(query)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<FarmacyMedicine> listAllFarmacyMedicines() {
        List<FarmacyMedicine> farmacyMedicines = new ArrayList<>();
        String query = "SELECT * FROM farmacyMedicine";
        try (Connection con = databaseConnection.connectDatabase();
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                FarmacyMedicine farmacyMedicine = new FarmacyMedicine();
                farmacyMedicine.setIdFarmacyMedicine(rs.getInt("idFarmacyMedicine"));
                farmacyMedicine.setIdFarmacy(rs.getInt("idFarmacy"));
                farmacyMedicine.setIdMedicineFatrm(rs.getInt("idMedicineFatrm"));
                farmacyMedicine.setPrice(rs.getDouble("price"));
                farmacyMedicines.add(farmacyMedicine);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return farmacyMedicines;
    }
}
