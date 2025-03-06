package Servlet;

import java.io.IOException;
import java.util.List;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import Dao.BillDAO;
import Bean.BillBean;

@WebServlet("/BillServlet")
public class BillServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        BillDAO dao = new BillDAO();
        List<BillBean> bookings = dao.getAllBookings();
        request.setAttribute("bookings", bookings);
        request.getRequestDispatcher("bills.jsp").forward(request, response);
    }
}
