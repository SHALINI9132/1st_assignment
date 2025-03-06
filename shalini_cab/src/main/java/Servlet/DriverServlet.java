package Servlet;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import Bean.DriverBean;
import Dao.DriverDAO;

@WebServlet("/DriverServlet")
public class DriverServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String phoneNumber = request.getParameter("phone_number");
        String licenseNumber = request.getParameter("license_number");
        String email = request.getParameter("email");

        DriverBean driver = new DriverBean();
        driver.setUsername(username);
        driver.setPhoneNumber(phoneNumber);
        driver.setLicenseNumber(licenseNumber);
        driver.setEmail(email);

        DriverDAO dao = new DriverDAO();
        boolean isRegistered = dao.registerDriver(driver);

        if (isRegistered) {
            request.setAttribute("message", "Registration successful!");
        } else {
            request.setAttribute("message", "Registration failed. Try again.");
        }

        request.getRequestDispatcher("drivers.jsp").forward(request, response);
    }
}
