package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import Bean.BillBean;

public class BillDAO {
    private static final String URL = "jdbc:mysql://localhost:3306/project";
    private static final String USER = "root";
    private static final String PASSWORD = "123456789";

    public List<BillBean> getAllBookings() {
        List<BillBean> list = new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
            String sql = "SELECT * FROM booked_details";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                BillBean booking = new BillBean();
                booking.setId(rs.getInt("id"));
                booking.setUsername(rs.getString("username"));
                booking.setPhoneNumber(rs.getString("phone_number"));
                booking.setPickupLocation(rs.getString("pickup_location"));
                booking.setDropLocation(rs.getString("drop_location"));
                booking.setCab(rs.getString("cab"));
                booking.setDistance(rs.getInt("distance"));
                booking.setAmount(rs.getInt("distance") * 6 + 500); // Calculation

                list.add(booking);
            }
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
