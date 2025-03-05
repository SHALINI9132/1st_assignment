package Servlet;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import Bean.BookingBean;
import Dao.BookingDAO;

@WebServlet("/BookingServlet")
public class BookingServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String phoneNumber = request.getParameter("phone_number");
        String pickupLocation = request.getParameter("pickup_location");
        String dropLocation = request.getParameter("drop_location");
        String cab = request.getParameter("cab");
        int distance = Integer.parseInt(request.getParameter("distance"));

        BookingBean booking = new BookingBean();
        booking.setUsername(username);
        booking.setPhoneNumber(phoneNumber);
        booking.setPickupLocation(pickupLocation);
        booking.setDropLocation(dropLocation);
        booking.setCab(cab);
        booking.setDistance(distance);

        BookingDAO dao = new BookingDAO();
        boolean isBooked = dao.saveBooking(booking);

        if (isBooked) {
            response.sendRedirect("home.jsp?message=Booking successful!");
        } else {
            response.sendRedirect("home.jsp?message=Booking failed. Try again.");
        }
    }
}
