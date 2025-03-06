package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import Bean.AdminLoginBean;

public class AdminLoginDAO {
    private static final String URL = "jdbc:mysql://localhost:3306/project"; 
    private static final String USER = "root";  
    private static final String PASSWORD = "123456789";  

    public boolean validateAdmin(AdminLoginBean admin) {
        try {
            // Load JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish Connection
            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);

            // SQL Query to check admin credentials
            String query = "SELECT * FROM admin WHERE username=? AND password=?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, admin.getUsername());
            ps.setString(2, admin.getPassword());

            ResultSet rs = ps.executeQuery();

            // If a matching record is found, return true
            boolean isValid = rs.next();
            conn.close();
            return isValid;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
