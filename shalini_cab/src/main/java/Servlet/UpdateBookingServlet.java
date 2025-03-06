package Servlet;

import java.io.IOException;
import Dao.BillDAO;
import Bean.BillBean;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/UpdateBookingServlet")
public class UpdateBookingServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String username = request.getParameter("username");
        String phoneNumber = request.getParameter("phoneNumber");
        String pickupLocation = request.getParameter("pickupLocation");
        String dropLocation = request.getParameter("dropLocation");
        String cab = request.getParameter("cab");
        int distance = Integer.parseInt(request.getParameter("distance"));

        double amount = distance * 6 + 500;  // Recalculate the amount

        BillBean booking = new BillBean();
        booking.setId(id);
        booking.setUsername(username);
        booking.setPhoneNumber(phoneNumber);
        booking.setPickupLocation(pickupLocation);
        booking.setDropLocation(dropLocation);
        booking.setCab(cab);
        booking.setDistance(distance);
        booking.setAmount(amount);

        BillDAO dao = new BillDAO();
        dao.updateBooking(booking);

        response.sendRedirect("bills.jsp");
    }
}
