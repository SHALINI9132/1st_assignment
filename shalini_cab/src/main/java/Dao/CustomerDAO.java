package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import Bean.CustomerBean;

public class CustomerDAO {
    private static final String URL = "jdbc:mysql://localhost:3306/project"; // Change DB name
    private static final String USER = "root";  // Change username if needed
    private static final String PASSWORD = "123456789";  // Change password if set

    public boolean saveUser(CustomerBean user) {
        boolean status = false;
        Connection conn = null;
        try {
            // Load MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Establish Connection
            conn = DriverManager.getConnection(URL, USER, PASSWORD);

            // Insert Query
            String query = "INSERT INTO Customer (username, password, mail_id, phone_number, address, nic_number) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword()); // Consider hashing in real apps
            ps.setString(3, user.getMailId());
            ps.setString(4, user.getPhoneNumber());
            ps.setString(5, user.getAddress());
            ps.setString(6, user.getNicNumber());

            // Execute Query
            int rowsInserted = ps.executeUpdate();
            if (rowsInserted > 0) {
                status = true;
            }

            // Close Connection
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }
}
