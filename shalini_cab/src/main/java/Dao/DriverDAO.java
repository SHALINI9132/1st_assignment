package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import Bean.DriverBean;

public class DriverDAO {
    private static final String URL = "jdbc:mysql://localhost:3306/project"; 
    private static final String USER = "root"; 
    private static final String PASSWORD = "123456789"; 

    public boolean registerDriver(DriverBean driver) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);

            String query = "INSERT INTO drivers (username, phone_number, license_number, email) VALUES (?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, driver.getUsername());
            ps.setString(2, driver.getPhoneNumber());
            ps.setString(3, driver.getLicenseNumber());
            ps.setString(4, driver.getEmail());

            int rowsInserted = ps.executeUpdate();
            conn.close();
            return rowsInserted > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
