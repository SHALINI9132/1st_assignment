package Servlet;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import Bean.CustomerBean;
import Dao.CustomerDAO;

@WebServlet("/CustomerServlet")
public class CustomerServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String mailId = request.getParameter("mail_id");
        String phoneNumber = request.getParameter("phone_number");
        String address = request.getParameter("address");
        String nicNumber = request.getParameter("nic_number");

        // Create Customer Object
        CustomerBean customer = new CustomerBean();
        customer.setUsername(username);
        customer.setPassword(password);
        customer.setMailId(mailId);
        customer.setPhoneNumber(phoneNumber);
        customer.setAddress(address);
        customer.setNicNumber(nicNumber);

        // Call DAO to save data
        CustomerDAO dao = new CustomerDAO();
        boolean isRegistered = dao.registerCustomer(customer);

        // Set message and redirect
        if (isRegistered) {
            request.setAttribute("message", "Registration successful!");
        } else {
            request.setAttribute("message", "Registration failed! Try again.");
        }
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
}
