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

    // Method to get booking details by ID
    public BillBean getBookingById(int id) {
        BillBean booking = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
            String sql = "SELECT * FROM booked_details WHERE id=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                booking = new BillBean();
                booking.setId(rs.getInt("id"));
                booking.setUsername(rs.getString("username"));
                booking.setPhoneNumber(rs.getString("phone_number"));
                booking.setPickupLocation(rs.getString("pickup_location"));
                booking.setDropLocation(rs.getString("drop_location"));
                booking.setCab(rs.getString("cab"));
                booking.setDistance(rs.getInt("distance"));
                booking.setAmount(rs.getInt("distance") * 6 + 500); // Calculation
            }
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return booking;
    }

    // Method to update booking details
    public boolean updateBooking(BillBean booking) {
        boolean rowUpdated = false;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
            String sql = "UPDATE booked_details SET username=?, phone_number=?, pickup_location=?, drop_location=?, cab=?, distance=? WHERE id=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, booking.getUsername());
            ps.setString(2, booking.getPhoneNumber());
            ps.setString(3, booking.getPickupLocation());
            ps.setString(4, booking.getDropLocation());
            ps.setString(5, booking.getCab());
            ps.setInt(6, booking.getDistance());
            ps.setInt(7, booking.getId());

            rowUpdated = ps.executeUpdate() > 0;
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rowUpdated;
    }

    // Method to delete a booking
    public boolean deleteBooking(int id) {
        boolean rowDeleted = false;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
            String sql = "DELETE FROM booked_details WHERE id=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            rowDeleted = ps.executeUpdate() > 0;
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rowDeleted;
    }
}
