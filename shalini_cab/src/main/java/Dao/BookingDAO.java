package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import Bean.BookingBean;

public class BookingDAO {
    private static final String URL = "jdbc:mysql://localhost:3306/project";
    private static final String USER = "root";
    private static final String PASSWORD = "123456789";

    public boolean saveBooking(BookingBean booking) {
        boolean success = false;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);

            String query = "INSERT INTO booked_details (username, phone_number, pickup_location, drop_location, cab, distance) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, booking.getUsername());
            ps.setString(2, booking.getPhoneNumber());
            ps.setString(3, booking.getPickupLocation());
            ps.setString(4, booking.getDropLocation());
            ps.setString(5, booking.getCab());
            ps.setInt(6, booking.getDistance());

            int rowsInserted = ps.executeUpdate();
            if (rowsInserted > 0) {
                success = true;
            }
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return success;
    }
}
