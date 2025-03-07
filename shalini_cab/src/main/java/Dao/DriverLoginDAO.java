package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DriverLoginDAO {
    
    // Database Connection Details
    private static final String URL = "jdbc:mysql://localhost:3306/project";
    private static final String USER = "root";
    private static final String PASSWORD = "123456789";

    public boolean validateDriver(String username, String licenseNumber) {
        String sql = "SELECT * FROM drivers WHERE username = ? AND license_number = ?";
        
        try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement ps = con.prepareStatement(sql)) {
            
            ps.setString(1, username);
            ps.setString(2, licenseNumber);
            ResultSet rs = ps.executeQuery();
            
            return rs.next();  // Returns true if driver exists, otherwise false
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
