package Servlet;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import Bean.CustomerBean;
import Dao.CustomerDAO;

@WebServlet("/UpdateCustomerServlet")
public class UpdateCustomerServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        String username = (String) session.getAttribute("username");

        if (username == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        String password = request.getParameter("password");
        String mailId = request.getParameter("mail_id");
        String phoneNumber = request.getParameter("phone_number");
        String address = request.getParameter("address");
        String nicNumber = request.getParameter("nic_number");

        CustomerBean customer = new CustomerBean();
        customer.setUsername(username);
        customer.setPassword(password);
        customer.setMailId(mailId);
        customer.setPhoneNumber(phoneNumber);
        customer.setAddress(address);
        customer.setNicNumber(nicNumber);

        CustomerDAO dao = new CustomerDAO();
        boolean isUpdated = dao.updateCustomer(customer);

        if (isUpdated) {
            response.sendRedirect("settings.jsp?success=Details Updated Successfully");
        } else {
            response.sendRedirect("settings.jsp?error=Update Failed");
        }
    }
}
