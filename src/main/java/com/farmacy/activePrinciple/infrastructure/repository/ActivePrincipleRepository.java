package com.farmacy.activePrinciple.infrastructure.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.farmacy.database.DatabaseConnection;
import com.farmacy.activePrinciple.domain.entity.ActivePrinciple;
import com.farmacy.activePrinciple.domain.service.ActivePrincipleService;

public class ActivePrincipleRepository implements ActivePrincipleService {
    private Connection con;

    public ActivePrincipleRepository() {
        DatabaseConnection database = new DatabaseConnection();
        con = database.connectDatabase();
    }

    @Override
    public void createActivePrinciple(ActivePrinciple activePrinciple) {
        String insertQuery = "INSERT INTO activePrinciple (nameAp) VALUES (?)";
        try (PreparedStatement ps = con.prepareStatement(insertQuery, PreparedStatement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, activePrinciple.getNameAp());
            ps.executeUpdate();
            try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    activePrinciple.setIdAp(generatedKeys.getLong(1));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteActivePrinciple(long idAp) {
        String deleteQuery = "DELETE FROM activePrinciple WHERE idAp = ?";
        try (PreparedStatement ps = con.prepareStatement(deleteQuery)) {
            ps.setLong(1, idAp);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Optional<ActivePrinciple> findActivePrincipleById(long idAp) {
        String findByIdQuery = "SELECT idAp, nameAp FROM activePrinciple WHERE idAp = ?";
        try (PreparedStatement ps = con.prepareStatement(findByIdQuery)) {
            ps.setLong(1, idAp);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    long id = rs.getLong("idAp");
                    String name = rs.getString("nameAp");
                    ActivePrinciple activePrinciple = new ActivePrinciple(id, name);
                    return Optional.of(activePrinciple);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public void updateActivePrinciple(long idAp, String nameAp) {
        String updateQuery = "UPDATE activePrinciple SET nameAp = ? WHERE idAp = ?";
        try (PreparedStatement ps = con.prepareStatement(updateQuery)) {
            ps.setString(1, nameAp);
            ps.setLong(2, idAp);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<ActivePrinciple> findAllActivePrinciples() {
        List<ActivePrinciple> activePrinciples = new ArrayList<>();
        String query = "SELECT idAp, nameAp FROM activePrinciple";
        try (PreparedStatement ps = con.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                long id = rs.getLong("idAp");
                String name = rs.getString("nameAp");
                activePrinciples.add(new ActivePrinciple(id, name));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return activePrinciples;
    }
}
