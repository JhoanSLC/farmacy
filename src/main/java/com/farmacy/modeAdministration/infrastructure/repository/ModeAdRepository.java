package com.farmacy.modeAdministration.infrastructure.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

import com.farmacy.modeAdministration.domain.entitiy.ModeAdministration;
import com.farmacy.modeAdministration.domain.service.ModeAdService;

import database.DatabaseConnection;

public class ModeAdRepository implements ModeAdService {
    private Connection con;

    public ModeAdRepository(){
        DatabaseConnection database = new DatabaseConnection();

        con = database.connectDatabase();
    }

    @Override
    public void createModeAd(ModeAdministration modeAd) {
        String insertModeAd = "INSERT INTO modeAdministration (descriptionMode) VALUES (?)";

        try (PreparedStatement ps = con.prepareStatement(insertModeAd,PreparedStatement.RETURN_GENERATED_KEYS)){
            ps.setString(1, modeAd.getDescriptionMode());
            ps.executeUpdate();

            try (ResultSet generatedKeys = ps.getGeneratedKeys()){
                if (generatedKeys.next()) {
                    modeAd.setId(generatedKeys.getLong((1)));
                }
            }
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }

    @Override
    public void deleteModeAd(Long id) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public Optional<ModeAdministration> findModeAdById(Long id) {
        // TODO Auto-generated method stub
        return Optional.empty();
    }

    @Override
    public void updateModeAd(Long id) {
        // TODO Auto-generated method stub
        
    }

    
}
