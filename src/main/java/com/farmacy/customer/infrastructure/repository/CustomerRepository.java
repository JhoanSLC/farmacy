package com.farmacy.customer.infrastructure.repository;

import com.farmacy.customer.domain.entity.Customer;
import com.farmacy.customer.domain.service.CustomerService;
import com.farmacy.database.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CustomerRepository implements CustomerService {
    private final DatabaseConnection databaseConnection = new DatabaseConnection();

    @Override
    public void createCustomer(Customer customer) {
        String query = "INSERT INTO customer (idCustomer, nameCustomer, lastNameCustomer, codeCityCustomer, " +
                       "emailCustomer, birthDate, lon, latitud) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection con = databaseConnection.connectDatabase();
             PreparedStatement stmt = con.prepareStatement(query)) {
            stmt.setString(1, customer.getIdCustomer());
            stmt.setString(2, customer.getNameCustomer());
            stmt.setString(3, customer.getLastNameCustomer());
            stmt.setString(4, customer.getCodeCityCustomer());
            stmt.setString(5, customer.getEmailCustomer());
            stmt.setDate(6, customer.getBirthDate());
            stmt.setDouble(7, customer.getLon());
            stmt.setDouble(8, customer.getLatitud());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Optional<Customer> findCustomerById(String idCustomer) {
        String query = "SELECT idCustomer,nameCustomer,lastNameCustomer,codeCityCustomer,emailCustomer,birthDate,lon,latitud FROM customer WHERE idCustomer = ?";
        try (Connection con = databaseConnection.connectDatabase();
             PreparedStatement stmt = con.prepareStatement(query)) {
            stmt.setString(1, idCustomer);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Customer customer = new Customer();
                customer.setIdCustomer(rs.getString("idCustomer"));
                customer.setNameCustomer(rs.getString("nameCustomer"));
                customer.setLastNameCustomer(rs.getString("lastNameCustomer"));
                customer.setCodeCityCustomer(rs.getString("codeCityCustomer"));
                customer.setEmailCustomer(rs.getString("emailCustomer"));
                customer.setBirthDate(rs.getDate("birthDate"));
                customer.setLon(rs.getDouble("lon"));
                customer.setLatitud(rs.getDouble("latitud"));
                return Optional.of(customer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public void updateCustomer(Customer customer) {
        String query = "UPDATE customer SET nameCustomer = ?, lastNameCustomer = ?, codeCityCustomer = ?, " +
                       "emailCustomer = ?, birthDate = ?, lon = ?, latitud = ? WHERE idCustomer = ?";
        try (Connection con = databaseConnection.connectDatabase();
             PreparedStatement stmt = con.prepareStatement(query)) {
            stmt.setString(1, customer.getNameCustomer());
            stmt.setString(2, customer.getLastNameCustomer());
            stmt.setString(3, customer.getCodeCityCustomer());
            stmt.setString(4, customer.getEmailCustomer());
            stmt.setDate(5, customer.getBirthDate());
            stmt.setDouble(6, customer.getLon());
            stmt.setDouble(7, customer.getLatitud());
            stmt.setString(8, customer.getIdCustomer());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteCustomer(String idCustomer) {
        String query = "DELETE FROM customer WHERE idCustomer = ?";
        try (Connection con = databaseConnection.connectDatabase();
             PreparedStatement stmt = con.prepareStatement(query)) {
            stmt.setString(1, idCustomer);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Customer> listAllCustomers() {
        List<Customer> customers = new ArrayList<>();
        String query = "SELECT idCustomer,nameCustomer,lastNameCustomer,codeCityCustomer,emailCustomer,birthDate,lon,latitud FROM customer";
        try (Connection con = databaseConnection.connectDatabase();
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                Customer customer = new Customer();
                customer.setIdCustomer(rs.getString("idCustomer"));
                customer.setNameCustomer(rs.getString("nameCustomer"));
                customer.setLastNameCustomer(rs.getString("lastNameCustomer"));
                customer.setCodeCityCustomer(rs.getString("codeCityCustomer"));
                customer.setEmailCustomer(rs.getString("emailCustomer"));
                customer.setBirthDate(rs.getDate("birthDate"));
                customer.setLon(rs.getDouble("lon"));
                customer.setLatitud(rs.getDouble("latitud"));
                customers.add(customer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customers;
    }
}
