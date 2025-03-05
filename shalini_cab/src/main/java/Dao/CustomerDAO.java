package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import Bean.CustomerBean;

public class CustomerDAO {
    private static final String URL = "jdbc:mysql://localhost:3306/project"; 
    private static final String USER = "root";  
    private static final String PASSWORD = "123456789";  

    public boolean registerCustomer(CustomerBean customer) {
        try {
            // Load MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish Connection
            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);

            // SQL Query to insert data
            String query = "INSERT INTO Customer (username, password, mail_id, phone_number, address, nic_number) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, customer.getUsername());
            ps.setString(2, customer.getPassword());
            ps.setString(3, customer.getMailId());
            ps.setString(4, customer.getPhoneNumber());
            ps.setString(5, customer.getAddress());
            ps.setString(6, customer.getNicNumber());

            // Execute Query
            int rowsInserted = ps.executeUpdate();

            // Close connection
            conn.close();

            return rowsInserted > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
