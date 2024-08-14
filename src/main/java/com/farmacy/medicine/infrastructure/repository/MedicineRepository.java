package com.farmacy.medicine.infrastructure.repository;

import com.farmacy.medicine.domain.entity.Medicine;
import com.farmacy.medicine.domain.service.MedicineService;
import com.farmacy.database.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MedicineRepository implements MedicineService {
    private final DatabaseConnection databaseConnection = new DatabaseConnection();

    @Override
    public void createMedicine(Medicine medicine) {
        String query = "INSERT INTO medicine (proceedings, nameMedicine, healthRegister, descriptionLong, descriptionShort, codeModeAdmin, codeAp, codeUm, nameRol, codeLab) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection con = databaseConnection.connectDatabase();
            PreparedStatement stmt = con.prepareStatement(query)) {
            stmt.setString(1, medicine.getProceedings());
            stmt.setString(2, medicine.getNameMedicine());
            stmt.setString(3, medicine.getHealthRegister());
            stmt.setString(4, medicine.getDescriptionLong());
            stmt.setString(5, medicine.getDescriptionShort());
            stmt.setInt(6, medicine.getCodeModeAdmin());
            stmt.setInt(7, medicine.getCodeAp());
            stmt.setInt(8, medicine.getCodeUm());
            stmt.setString(9, medicine.getNameRol());
            stmt.setInt(10, medicine.getCodeLab());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Optional<Medicine> findMedicineById(int id) {
        String query = "SELECT * FROM medicine WHERE id = ?";
        try (Connection con = databaseConnection.connectDatabase();
             PreparedStatement stmt = con.prepareStatement(query)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Medicine medicine = new Medicine();
                medicine.setId(rs.getInt("id"));
                medicine.setProceedings(rs.getString("proceedings"));
                medicine.setNameMedicine(rs.getString("nameMedicine"));
                medicine.setHealthRegister(rs.getString("healthRegister"));
                medicine.setDescriptionLong(rs.getString("descriptionLong"));
                medicine.setDescriptionShort(rs.getString("descriptionShort"));
                medicine.setCodeModeAdmin(rs.getInt("codeModeAdmin"));
                medicine.setCodeAp(rs.getInt("codeAp"));
                medicine.setCodeUm(rs.getInt("codeUm"));
                medicine.setNameRol(rs.getString("nameRol"));
                medicine.setCodeLab(rs.getInt("codeLab"));
                return Optional.of(medicine);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public void updateMedicine(int id, String nameMedicine, String descriptionShort, String descriptionLong) {
        String query = "UPDATE medicine SET nameMedicine = ?, descriptionShort = ?, descriptionLong = ? WHERE id = ?";
        try (Connection con = databaseConnection.connectDatabase();
             PreparedStatement stmt = con.prepareStatement(query)) {
            stmt.setString(1, nameMedicine);
            stmt.setString(2, descriptionShort);
            stmt.setString(3, descriptionLong);
            stmt.setInt(4, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteMedicine(int id) {
        String query = "DELETE FROM medicine WHERE id = ?";
        try (Connection con = databaseConnection.connectDatabase();
             PreparedStatement stmt = con.prepareStatement(query)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Medicine> listAllMedicines() {
        List<Medicine> medicines = new ArrayList<>();
        String query = "SELECT * FROM medicine";
        try (Connection con = databaseConnection.connectDatabase();
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                Medicine medicine = new Medicine();
                medicine.setId(rs.getInt("id"));
                medicine.setProceedings(rs.getString("proceedings"));
                medicine.setNameMedicine(rs.getString("nameMedicine"));
                medicine.setHealthRegister(rs.getString("healthRegister"));
                medicine.setDescriptionLong(rs.getString("descriptionLong"));
                medicine.setDescriptionShort(rs.getString("descriptionShort"));
                medicine.setCodeModeAdmin(rs.getInt("codeModeAdmin"));
                medicine.setCodeAp(rs.getInt("codeAp"));
                medicine.setCodeUm(rs.getInt("codeUm"));
                medicine.setNameRol(rs.getString("nameRol"));
                medicine.setCodeLab(rs.getInt("codeLab"));
                medicines.add(medicine);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return medicines;
    }
}
