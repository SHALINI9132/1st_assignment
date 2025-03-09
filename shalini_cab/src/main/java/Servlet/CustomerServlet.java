package Servlet;

import java.io.IOException;
import Dao.CustomerDAO;
import Bean.CustomerBean;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/CustomerServlet")
public class CustomerServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Get form data
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String mailId = request.getParameter("mail_id");
        String phoneNumber = request.getParameter("phone_number");
        String address = request.getParameter("address");
        String nicNumber = request.getParameter("nic_number");

        CustomerBean user = new CustomerBean();
        user.setUsername(username);
        user.setPassword(password);
        user.setMailId(mailId);
        user.setPhoneNumber(phoneNumber);
        user.setAddress(address);
        user.setNicNumber(nicNumber);

        CustomerDAO dao = new CustomerDAO();
        boolean result = dao.saveUser(user);

        if (result) {
            response.sendRedirect("index.jsp?success=Registration successful! Please login.");
        } else {
            response.sendRedirect("index.jsp?error=Registration successful.");
        }
    }
}