package Servlet;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import Bean.BillBean;
import Dao.BillDAO;

@WebServlet("/EditBookingServlet")
public class EditBookingServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            BillDAO dao = new BillDAO();
            BillBean booking = dao.getBookingById(id);

            if (booking != null) {
                request.setAttribute("booking", booking);
                request.getRequestDispatcher("edit_booking.jsp").forward(request, response);
            } else {
                response.sendRedirect("bills.jsp?error=BookingNotFound");
            }
        } catch (NumberFormatException e) {
            response.sendRedirect("bills.jsp?error=InvalidBookingId");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            String username = request.getParameter("username");
            String phoneNumber = request.getParameter("phoneNumber");
            String pickupLocation = request.getParameter("pickupLocation");
            String dropLocation = request.getParameter("dropLocation");
            String cab = request.getParameter("cab");
            int distance = Integer.parseInt(request.getParameter("distance"));
            double amount = distance * 6 + 500; // Amount calculation

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
            boolean status = dao.updateBooking(booking);

            if (status) {
                response.sendRedirect("bills.jsp?success=BookingUpdated");
            } else {
                response.sendRedirect("edit_booking.jsp?id=" + id + "&error=UpdateFailed");
            }
        } catch (NumberFormatException e) {
            response.sendRedirect("bills.jsp?error=InvalidInput");
        }
    }
}
