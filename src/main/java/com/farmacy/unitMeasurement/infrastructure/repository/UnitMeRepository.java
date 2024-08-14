package com.farmacy.unitMeasurement.infrastructure.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

import com.farmacy.database.DatabaseConnection;
import com.farmacy.unitMeasurement.domain.entity.UnitMeasurement;
import com.farmacy.unitMeasurement.domain.service.UnitMeasurementService;

public class UnitMeRepository implements UnitMeasurementService{
    private final Connection con;

    public UnitMeRepository() {
        DatabaseConnection database = new DatabaseConnection();
        con = database.connectDatabase();
    }

    @Override
    public void createUnitMeasurement(UnitMeasurement unitMeasurement) {
        String insertUnitMeasurement = "INSERT INTO unitMeasurement (nameUm) VALUES (?)";

        try (PreparedStatement ps = con.prepareStatement(insertUnitMeasurement, PreparedStatement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, unitMeasurement.getNameUm());
            ps.executeUpdate();

            try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    unitMeasurement.setIdUm(generatedKeys.getLong(1));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteUnitMeasurement(long id) {
        String deleteUnitMeasurement = "DELETE FROM unitMeasurement WHERE idUm = ?";

        try (PreparedStatement ps = con.prepareStatement(deleteUnitMeasurement)) {
            ps.setLong(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Optional<UnitMeasurement> findUnitMeasurementById(long id) {
        String findByIdQuery = "SELECT idUm, nameUm FROM unitMeasurement WHERE idUm = ?";

        try (PreparedStatement ps = con.prepareStatement(findByIdQuery)) {
            ps.setLong(1, id);

            try (ResultSet set = ps.executeQuery()) {
                if (set.next()) {
                    long resultId = set.getLong("idUm");
                    String resultName = set.getString("nameUm");

                    System.out.printf("Id: %d%nName: %s%n", resultId, resultName);
                    UnitMeasurement searchedUnitMeasurement = new UnitMeasurement(resultId, resultName);
                    return Optional.of(searchedUnitMeasurement);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public void updateUnitMeasurement(long id, String nameUm) {
        String updateQuery = "UPDATE unitMeasurement SET nameUm = ? WHERE idUm = ?";

        try (PreparedStatement ps = con.prepareStatement(updateQuery)) {
            ps.setString(1, nameUm);
            ps.setLong(2, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
