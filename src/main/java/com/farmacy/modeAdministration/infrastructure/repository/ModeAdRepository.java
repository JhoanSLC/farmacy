package com.farmacy.modeAdministration.infrastructure.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

import com.farmacy.database.DatabaseConnection;
import com.farmacy.modeAdministration.domain.entitiy.ModeAdministration;
import com.farmacy.modeAdministration.domain.service.ModeAdService;

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
    public void deleteModeAd(long id) {
        String deleteModeAd = "DELETE FROM modeAdministration WHERE id = ?";

        try (PreparedStatement ps = con.prepareStatement(deleteModeAd)){
           ps.setLong(1, id); 
           ps.executeUpdate();
           ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }

    @Override
    public Optional<ModeAdministration> findModeAdById(long id) {
        String findByIdQuery = "SELECT id, descriptionMode FROM modeAdministration WHERE id = ?";
        try (PreparedStatement ps = con.prepareStatement(findByIdQuery)){
            ps.setLong(1, id);

            try (ResultSet set = ps.executeQuery()){
                if (set.next()){
                    long resultId = set.getLong("id");
                    String resultDescription = set.getString("descriptionMode");
    
                    System.out.printf("Id: %d%nDescription: %s",resultId,resultDescription);
                    ModeAdministration searchedModeAd = new ModeAdministration(resultId,resultDescription);
                    return Optional.of(searchedModeAd);
                }
            };

        } catch (Exception e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public void updateModeAd(long id, String description) {
         String updateQuery = "UPDATE modeAdministration SET descriptionMode = ? WHERE id = ?";
        try (PreparedStatement ps = con.prepareStatement(updateQuery)) {
            ps.setString(1, description);
            ps.setLong(2, id);

            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }

    
}
