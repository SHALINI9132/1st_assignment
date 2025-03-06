package Servlet;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import Bean.AdminLoginBean;
import Dao.AdminLoginDAO;

@WebServlet("/AdminLoginServlet")
public class AdminLoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        AdminLoginBean admin = new AdminLoginBean();
        admin.setUsername(username);
        admin.setPassword(password);

        AdminLoginDAO dao = new AdminLoginDAO();
        boolean isValid = dao.validateAdmin(admin);

        if (isValid) {
            HttpSession session = request.getSession();
            session.setAttribute("adminUsername", username);
            response.sendRedirect("adminHome.jsp"); // Redirect to admin home
        } else {
            request.setAttribute("errorMessage", "Invalid Username or Password!");
            request.getRequestDispatcher("adminLogin.jsp").forward(request, response);
        }
    }
}
