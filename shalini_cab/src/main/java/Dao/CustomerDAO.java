package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import Bean.CustomerBean;

public class CustomerDAO {
    private static final String URL = "jdbc:mysql://localhost:3306/project"; 
    private static final String USER = "root";  
    private static final String PASSWORD = "123456789";  

    // Fetch customer details by username
    public CustomerBean getCustomerByUsername(String username) {
        CustomerBean customer = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);

            String query = "SELECT * FROM Customer WHERE username = ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                customer = new CustomerBean();
                customer.setUsername(rs.getString("username"));
                customer.setPassword(rs.getString("password"));
                customer.setMailId(rs.getString("mail_id"));
                customer.setPhoneNumber(rs.getString("phone_number"));
                customer.setAddress(rs.getString("address"));
                customer.setNicNumber(rs.getString("nic_number"));
            }

            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return customer;
    }

    // Update customer details
    public boolean updateCustomer(CustomerBean customer) {
        boolean updated = false;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);

            String query = "UPDATE Customer SET password=?, mail_id=?, phone_number=?, address=?, nic_number=? WHERE username=?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, customer.getPassword());
            ps.setString(2, customer.getMailId());
            ps.setString(3, customer.getPhoneNumber());
            ps.setString(4, customer.getAddress());
            ps.setString(5, customer.getNicNumber());
            ps.setString(6, customer.getUsername());

            updated = ps.executeUpdate() > 0;
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return updated;
    }

	public boolean registerCustomer(CustomerBean customer) {
		// TODO Auto-generated method stub
		return false;
	}
}
