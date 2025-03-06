package Servlet;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import Dao.BillDAO;

@WebServlet("/DeleteBookingServlet")
public class DeleteBookingServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        BillDAO dao = new BillDAO();
        boolean status = dao.deleteBooking(id);
        if (status) {
            response.sendRedirect(request.getContextPath() + "/bills.jsp");
        } else {
            response.getWriter().println("Error deleting booking.");
        }
    }
}
