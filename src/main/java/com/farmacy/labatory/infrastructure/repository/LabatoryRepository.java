package com.farmacy.labatory.infrastructure.repository;

import com.farmacy.labatory.domain.entity.Labatory;
import com.farmacy.labatory.domain.service.LabatoryService;
import com.farmacy.database.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class LabatoryRepository implements LabatoryService {
    private final DatabaseConnection databaseConnection = new DatabaseConnection();

    @Override
    public void createLabatory(Labatory labatory) {
        String query = "INSERT INTO labatory (nameLab, codeCityReg) VALUES (?, ?)";
        try (Connection con = databaseConnection.connectDatabase();
            PreparedStatement stmt = con.prepareStatement(query)) {
            stmt.setString(1, labatory.getNameLab());
            stmt.setString(2, labatory.getCodeCityReg());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Optional<Labatory> findLabatoryById(int id) {
        String query = "SELECT * FROM labatory WHERE id = ?";
        try (Connection con = databaseConnection.connectDatabase();
             PreparedStatement stmt = con.prepareStatement(query)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Labatory labatory = new Labatory();
                labatory.setId(rs.getInt("id"));
                labatory.setNameLab(rs.getString("nameLab"));
                labatory.setCodeCityReg(rs.getString("codeCityReg"));
                return Optional.of(labatory);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public void updateLabatory(int id, String nameLab) {
        String query = "UPDATE labatory SET nameLab = ? WHERE id = ?";
        try (Connection con = databaseConnection.connectDatabase();
             PreparedStatement stmt = con.prepareStatement(query)) {
            stmt.setString(1, nameLab);
            stmt.setInt(2, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteLabatory(int id) {
        String query = "DELETE FROM labatory WHERE id = ?";
        try (Connection con = databaseConnection.connectDatabase();
             PreparedStatement stmt = con.prepareStatement(query)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Labatory> listAllLabatories() {
        List<Labatory> labs = new ArrayList<>();
        String query = "SELECT * FROM labatory";
        try (Connection con = databaseConnection.connectDatabase();
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                Labatory labatory = new Labatory();
                labatory.setId(rs.getInt("id"));
                labatory.setNameLab(rs.getString("nameLab"));
                labatory.setCodeCityReg(rs.getString("codeCityReg"));
                labs.add(labatory);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return labs;
    }
}
