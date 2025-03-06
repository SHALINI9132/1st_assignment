package Servlet;

import java.io.IOException;
import Bean.BillBean;
import Dao.BillDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/EditBookingServlet")
public class EditBookingServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        BillDAO dao = new BillDAO();
        BillBean booking = dao.getBookingById(id);
        request.setAttribute("booking", booking);
        request.getRequestDispatcher("edit_booking.jsp").forward(request, response);
    }
}
