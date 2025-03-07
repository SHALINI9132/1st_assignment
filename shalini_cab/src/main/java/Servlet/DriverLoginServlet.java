package Servlet;

import java.io.IOException;

import Dao.DriverLoginDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/DriverLoginServlet")
public class DriverLoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String licenseNumber = request.getParameter("license_number");

        DriverLoginDAO dao = new DriverLoginDAO();
        boolean isValid = dao.validateDriver(username, licenseNumber);

        if (isValid) {
            HttpSession session = request.getSession();
            session.setAttribute("driverUsername", username);
            response.sendRedirect("driverHome.jsp");
        } else {
            response.sendRedirect("driverLogin.jsp?error=Invalid Username or License Number");
        }
    }
}
