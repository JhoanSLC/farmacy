package com.farmacy.region.infrastructure.repository;

import com.farmacy.database.DatabaseConnection;
import com.farmacy.region.domain.entity.Region;
import com.farmacy.region.domain.service.RegionService;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class RegionRepository implements RegionService {
    private final DatabaseConnection databaseConnection = new DatabaseConnection();

    @Override
    public void createRegion(Region region) {
        String query = "INSERT INTO region (codeReg, nameReg, codeCountry) VALUES (?, ?, ?)";
        try (Connection con = databaseConnection.connectDatabase();
             PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, region.getCodeReg());
            ps.setString(2, region.getNameReg());
            ps.setString(3, region.getCodeCountry());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Optional<Region> findRegionById(String codeReg) {
        String query = "SELECT * FROM region WHERE codeReg = ?";
        try (Connection con = databaseConnection.connectDatabase();
             PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, codeReg);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Region region = new Region(
                        rs.getString("codeReg"),
                        rs.getString("nameReg"),
                        rs.getString("codeCountry")
                );
                return Optional.of(region);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public void updateRegion(String codeReg, String nameReg, String codeCountry) {
        String query = "UPDATE region SET nameReg = ?, codeCountry = ? WHERE codeReg = ?";
        try (Connection con = databaseConnection.connectDatabase();
             PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, nameReg);
            ps.setString(2, codeCountry);
            ps.setString(3, codeReg);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteRegion(String codeReg) {
        String query = "DELETE FROM region WHERE codeReg = ?";
        try (Connection con = databaseConnection.connectDatabase();
             PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, codeReg);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Region> listAllRegions() {
        List<Region> regions = new ArrayList<>();
        String query = "SELECT * FROM region";
        try (Connection con = databaseConnection.connectDatabase();
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                Region region = new Region(
                        rs.getString("codeReg"),
                        rs.getString("nameReg"),
                        rs.getString("codeCountry")
                );
                regions.add(region);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return regions;
    }
}
