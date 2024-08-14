package com.farmacy.customer.infrastructure.repository;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.util.List;
import java.util.Optional;

import com.farmacy.customer.domain.entity.Customer;
import com.farmacy.customer.domain.service.CustomerService;
import com.farmacy.database.DatabaseConnection;

public class CustomerRepository implements CustomerService{
    private Connection con;

    public CustomerRepository(){
        DatabaseConnection database = new DatabaseConnection();
        con = database.connectDatabase();
    }

    @Override
    public void createCustomer(Customer customer) {
        String insertQuery = "INSERT INTO customer (idCustomer,nameCustomer,lastNameCustomer,codeCityCustomer,emailCustomer,birthDate,lon,latitud)"+
                            "VALUES (?,?,?,?,?,?,?,?)";
        
        try (PreparedStatement ps = con.prepareStatement(insertQuery)){
            ps.setString(1, customer.getIdCustomer());
            ps.setString(2, customer.getNameCustomer());
            ps.setString(3, customer.getLastNameCustomer());
            ps.setString(4, customer.getCodeCityCustomer());
            ps.setString(5, customer.getEmailCustomer());
            ps.setDate(6, customer.getBirthDate());
            ps.setDouble(7, customer.getLon());
            ps.setDouble(8, customer.getLatitud());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }

    @Override
    public void deleteCustomer(long id) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public Optional<Customer> findCustomerById(long id) {
        // TODO Auto-generated method stub
        return Optional.empty();
    }

    @Override
    public List<Customer> listAllCustomers() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void updateCustomer(String id, String name, String lastName, String codeCity, String email, Date birthDate,
            double lon, double latitud) {
        // TODO Auto-generated method stub
        
    }

    

}
